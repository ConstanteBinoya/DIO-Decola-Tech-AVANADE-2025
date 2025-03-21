package br.com.binoya.taskflow.persistence.dao;

import br.com.binoya.taskflow.dto.CardDetailsDTO;
import br.com.binoya.taskflow.persistence.entity.TaskEntity;
import com.mysql.cj.jdbc.StatementImpl;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import static br.com.binoya.taskflow.persistence.converter.OffsetDateTimeConverter.toOffsetDateTime;
import static java.util.Objects.nonNull;

@AllArgsConstructor
public class TaskDAO {

    private Connection connection;

    public TaskEntity insert(final TaskEntity entity) throws SQLException {
        var sql = "INSERT INTO TASKS (title, description, board_column_id) values (?, ?, ?);";
        try(var statement = connection.prepareStatement(sql)){
            var i = 1;
            statement.setString(i++, entity.getTitle());
            statement.setString(i++, entity.getDescription());
            statement.setLong(i, entity.getBoardColumn().getId());
            statement.executeUpdate();
            if (statement instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
            }
        }
        return entity;
    }

    public void moveToColumn(final Long columnId, final Long taskId) throws SQLException{
        var sql = "UPDATE TASKS SET board_column_id = ? WHERE id = ?;";
        try(var statement = connection.prepareStatement(sql)){
            var i = 1;
            statement.setLong(i++, columnId);
            statement.setLong(i, taskId);
            statement.executeUpdate();
        }
    }

    public Optional<CardDetailsDTO> findById(final Long id) throws SQLException {
        var sql =
                """
                SELECT t.id,
                       t.title,
                       t.description,
                       b.blocked_at,
                       b.block_reason,
                       t.board_column_id,
                       bc.name,
                       (SELECT COUNT(sub_b.id)
                               FROM BLOCKS sub_b
                              WHERE sub_b.task_id = t.id) blocks_amount
                  FROM TASKS t
                  LEFT JOIN BLOCKS b
                    ON t.id = b.task_id
                   AND b.unblocked_at IS NULL
                 INNER JOIN BOARDS_COLUMNS bc
                    ON bc.id = t.board_column_id
                  WHERE t.id = ?;
                """;
        try(var statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            statement.executeQuery();
            var resultSet = statement.getResultSet();
            if (resultSet.next()){
                var dto = new CardDetailsDTO(
                        resultSet.getLong("t.id"),
                        resultSet.getString("t.title"),
                        resultSet.getString("t.description"),
                        nonNull(resultSet.getString("b.block_reason")),
                        toOffsetDateTime(resultSet.getTimestamp("b.blocked_at")),
                        resultSet.getString("b.block_reason"),
                        resultSet.getInt("blocks_amount"),
                        resultSet.getLong("t.board_column_id"),
                        resultSet.getString("bc.name")
                );
                return Optional.of(dto);
            }
        }
        return Optional.empty();
    }
}
