package br.com.binoya.taskflow.service;

import br.com.binoya.taskflow.dto.TaskDetailsDTO;
import br.com.binoya.taskflow.persistence.dao.TaskDAO;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@AllArgsConstructor
public class TaskQueryService {

    private final Connection connection;

    public Optional<TaskDetailsDTO> findById(final Long id) throws SQLException {
        var dao = new TaskDAO(connection);
        return dao.findById(id);
    }
}

