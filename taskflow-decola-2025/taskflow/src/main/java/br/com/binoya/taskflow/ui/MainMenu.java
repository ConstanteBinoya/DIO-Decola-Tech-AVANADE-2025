package br.com.binoya.taskflow.ui;

import br.com.binoya.taskflow.persistence.entity.BoardColumnEntity;
import br.com.binoya.taskflow.persistence.entity.BoardColumnKindEnum;
import br.com.binoya.taskflow.persistence.entity.BoardEntity;
import br.com.binoya.taskflow.service.BoardQueryService;
import br.com.binoya.taskflow.service.BoardService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static br.com.binoya.taskflow.persistence.config.ConnectionConfig.getConnection;
import static br.com.binoya.taskflow.persistence.entity.BoardColumnKindEnum.*;

public class MainMenu {

    private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public void execute() throws SQLException {
        System.out.println("Bem-vindo ao TaskFlow! Escolha uma opção:");
        var option = -1;
        while (true) {
            System.out.println("1 - Criar um novo quadro");
            System.out.println("2 - Selecionar um quadro existente");
            System.out.println("3 - Excluir um quadro");
            System.out.println("4 - Sair");
            option = scanner.nextInt();
            switch (option) {
                case 1 -> createBoard();
                case 2 -> selectBoard();
                case 3 -> deleteBoard();
                case 4 -> System.exit(0);
                default -> System.out.println("Opção inválida! Escolha novamente.");
            }
        }
    }

    private void createBoard() throws SQLException {
        var entity = new BoardEntity();
        System.out.println("Informe o nome do novo quadro:");
        entity.setName(scanner.next());

        System.out.println("Deseja adicionar colunas extras além das padrões? Se sim, informe quantas (0 para nenhuma)");
        var additionalColumns = scanner.nextInt();

        List<BoardColumnEntity> columns = new ArrayList<>();

        System.out.println("Nome da coluna inicial:");
        columns.add(createColumn(scanner.next(), INITIAL, 0));

        for (int i = 0; i < additionalColumns; i++) {
            System.out.println("Nome da coluna intermediária:");
            columns.add(createColumn(scanner.next(), PENDING, i + 1));
        }

        System.out.println("Nome da coluna final:");
        columns.add(createColumn(scanner.next(), FINAL, additionalColumns + 1));

        System.out.println("Nome da coluna de cancelamento:");
        columns.add(createColumn(scanner.next(), CANCEL, additionalColumns + 2));

        entity.setBoardColumns(columns);
        try (var connection = getConnection()) {
            new BoardService(connection).insert(entity);
        }
    }

    private void selectBoard() throws SQLException {
        System.out.println("Informe o ID do quadro que deseja abrir:");
        var id = scanner.nextLong();
        try (var connection = getConnection()) {
            var queryService = new BoardQueryService(connection);
            var optional = queryService.findById(id);
            optional.ifPresentOrElse(
                    board -> new BoardMenu(board).execute(),
                    () -> System.out.printf("Quadro com ID %s não encontrado!\n", id)
            );
        }
    }

    private void deleteBoard() throws SQLException {
        System.out.println("Informe o ID do quadro que deseja excluir:");
        var id = scanner.nextLong();
        try (var connection = getConnection()) {
            var service = new BoardService(connection);
            if (service.delete(id)) {
                System.out.printf("Quadro %s excluído com sucesso!\n", id);
            } else {
                System.out.printf("Quadro com ID %s não encontrado!\n", id);
            }
        }
    }

    private BoardColumnEntity createColumn(final String name, final BoardColumnKindEnum kind, final int order) {
        var boardColumn = new BoardColumnEntity();
        boardColumn.setName(name);
        boardColumn.setKind(kind);
        boardColumn.setOrder(order);
        return boardColumn;
    }
}