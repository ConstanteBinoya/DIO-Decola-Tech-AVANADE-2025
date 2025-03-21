package br.com.binoya.taskflow.ui;

import br.com.binoya.taskflow.dto.BoardColumnInfoDTO;
import br.com.binoya.taskflow.persistence.entity.BoardColumnEntity;
import br.com.binoya.taskflow.persistence.entity.BoardEntity;
import br.com.binoya.taskflow.persistence.entity.TaskEntity;
import br.com.binoya.taskflow.service.BoardColumnQueryService;
import br.com.binoya.taskflow.service.BoardQueryService;
import br.com.binoya.taskflow.service.TaskQueryService;
import br.com.binoya.taskflow.service.TaskService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.Scanner;

import static br.com.binoya.taskflow.persistence.config.ConnectionConfig.getConnection;

@AllArgsConstructor
public class BoardMenu {

    private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private final BoardEntity entity;

    public void execute() {
        try {
            System.out.printf("Bem-vindo ao TaskFlow! Gerenciando quadro: %s\n", entity.getId());
            var option = -1;
            while (option != 9) {
                System.out.println("1 - Criar uma tarefa");
                System.out.println("2 - Mover uma tarefa");
                System.out.println("3 - Bloquear uma tarefa");
                System.out.println("4 - Desbloquear uma tarefa");
                System.out.println("5 - Cancelar uma tarefa");
                System.out.println("6 - Visualizar quadro");
                System.out.println("7 - Visualizar colunas");
                System.out.println("8 - Visualizar tarefa");
                System.out.println("9 - Voltar para o menu principal");
                System.out.println("10 - Sair");
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> createTask();
                    case 2 -> moveTaskToNextColumn();
                    case 3 -> blockTask();
                    case 4 -> unblockTask();
                    case 5 -> cancelTask();
                    case 6 -> showBoard();
                    case 7 -> showColumn();
                    case 8 -> showTask();
                    case 9 -> System.out.println("Voltando para o menu principal...");
                    case 10 -> System.exit(0);
                    default -> System.out.println("Opção inválida! Escolha novamente.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(0);
        }
    }

    private void createTask() throws SQLException {
        var task = new TaskEntity();
        System.out.println("Informe o título da tarefa:");
        task.setTitle(scanner.next());
        System.out.println("Informe a descrição da tarefa:");
        task.setDescription(scanner.next());
        task.setBoardColumn(entity.getInitialColumn());
        try (var connection = getConnection()) {
            new TaskService(connection).create(task);
        }
    }

    private void moveTaskToNextColumn() throws SQLException {
        System.out.println("Informe o ID da tarefa a ser movida:");
        var taskId = scanner.nextLong();
        var boardColumnsInfo = entity.getBoardColumns().stream()
                .map(bc -> new BoardColumnInfoDTO(bc.getId(), bc.getOrder(), bc.getKind()))
                .toList();
        try (var connection = getConnection()) {
            new TaskService(connection).moveToNextColumn(taskId, boardColumnsInfo);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
