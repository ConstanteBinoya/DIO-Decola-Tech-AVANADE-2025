package br.com.binoya.taskflow.service;

import br.com.binoya.taskflow.dto.BoardColumnInfoDTO;
import br.com.binoya.taskflow.exception.TaskBlockedException;
import br.com.binoya.taskflow.exception.TaskFinishedException;
import br.com.binoya.taskflow.exception.EntityNotFoundException;
import br.com.binoya.taskflow.persistence.dao.BlockDAO;
import br.com.binoya.taskflow.persistence.dao.TaskDAO;
import br.com.binoya.taskflow.persistence.entity.TaskEntity;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static br.com.binoya.taskflow.persistence.entity.BoardColumnKindEnum.CANCEL;
import static br.com.binoya.taskflow.persistence.entity.BoardColumnKindEnum.FINAL;

@AllArgsConstructor
public class TaskService {

    private final Connection connection;

    public TaskEntity create(final TaskEntity entity) throws SQLException {
        try {
            var dao = new TaskDAO(connection);
            dao.insert(entity);
            connection.commit();
            return entity;
        } catch (SQLException ex){
            connection.rollback();
            throw ex;
        }
    }

    public void moveToNextColumn(final Long taskId, final List<BoardColumnInfoDTO> boardColumnsInfo) throws SQLException{
        try{
            var dao = new TaskDAO(connection);
            var optional = dao.findById(taskId);
            var dto = optional.orElseThrow(
                    () -> new EntityNotFoundException("A tarefa de id %s não foi encontrada".formatted(taskId))
            );
            if (dto.blocked()){
                var message = "A tarefa %s está bloqueada, é necessário desbloqueá-la para mover".formatted(taskId);
                throw new TaskBlockedException(message);
            }
            var currentColumn = boardColumnsInfo.stream()
                    .filter(bc -> bc.id().equals(dto.columnId()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("A tarefa informada pertence a outro quadro"));
            if (currentColumn.kind().equals(FINAL)){
                throw new TaskFinishedException("A tarefa já foi finalizada");
            }
            var nextColumn = boardColumnsInfo.stream()
                    .filter(bc -> bc.order() == currentColumn.order() + 1)
                    .findFirst().orElseThrow(() -> new IllegalStateException("A tarefa está cancelada"));
            dao.moveToColumn(nextColumn.id(), taskId);
            connection.commit();
        }catch (SQLException ex){
            connection.rollback();
            throw ex;
        }
    }
}
