package br.com.binoya.taskflow.service;

import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import br.com.binoya.taskflow.persistence.dao.BoardColumnDAO;
import br.com.binoya.taskflow.persistence.entity.BoardColumnEntity;

@AllArgsConstructor
public class BoardColumnQueryService {

    private final Connection connection;

    public Optional<BoardColumnEntity> findById(final Long id) throws SQLException {
        var dao = new BoardColumnDAO(connection);
        return dao.findById(id);
    }

}
