package br.com.binoya.taskflow.dto;

import br.com.binoya.taskflow.persistence.entity.BoardColumnKindEnum;

public record BoardColumnInfoDTO(Long id, int order, BoardColumnKindEnum kind) {
}
