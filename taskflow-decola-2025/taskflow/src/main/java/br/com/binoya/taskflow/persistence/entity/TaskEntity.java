package br.com.binoya.taskflow.persistence.entity;

import lombok.Data;

@Data
public class TaskEntity {

    private Long id;
    private String title;
    private String description;
    private BoardColumnEntity boardColumn = new BoardColumnEntity();
}
