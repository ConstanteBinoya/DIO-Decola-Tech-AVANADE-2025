package br.com.binoya.taskflow.persistence.config;

import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class ConnectionConfig {

    private static final String URL = "jdbc:mysql://localhost/taskflow";
    private static final String USER = "taskflow";
    private static final String PASSWORD = "taskflow";

    public static Connection getConnection() throws SQLException {
        var connection = DriverManager.getConnection(URL, USER, PASSWORD);
        connection.setAutoCommit(false);
        return connection;
    }
}
