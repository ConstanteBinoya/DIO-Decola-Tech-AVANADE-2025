package me.dio.d_t_avanade_2025.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe global para tratamento de exceções na API.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Trata exceções de usuário não encontrado.
	 */
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Map<String, Object>> handleUserNotFoundException(UserNotFoundException ex) {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("status", HttpStatus.NOT_FOUND.value());
		errorResponse.put("error", "Usuário não encontrado");
		errorResponse.put("message", ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}

	/**
	 * Trata exceções de recurso não encontrado.
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("status", HttpStatus.NOT_FOUND.value());
		errorResponse.put("error", "Recurso não encontrado");
		errorResponse.put("message", ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}

	/**
	 * Trata exceções de requisições inválidas.
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex) {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
		errorResponse.put("error", "Requisição inválida");
		errorResponse.put("message", ex.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	/**
	 * Trata exceções genéricas não tratadas explicitamente.
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.put("error", "Erro interno no servidor");
		errorResponse.put("message", ex.getMessage());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}
}
