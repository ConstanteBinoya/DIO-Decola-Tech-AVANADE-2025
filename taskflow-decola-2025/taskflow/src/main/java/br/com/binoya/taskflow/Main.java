package br.com.binoya.taskflow;

import br.com.binoya.taskflow.persistence.migration.MigrationStrategy;
import br.com.binoya.taskflow.ui.MainMenu;

import java.sql.SQLException;

import static br.com.binoya.taskflow.persistence.config.ConnectionConfig.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (var connection = getConnection()) {
            new MigrationStrategy(connection).executeMigration();
        }
        new MainMenu().execute();
    }
}
