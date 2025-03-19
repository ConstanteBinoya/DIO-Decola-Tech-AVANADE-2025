package me.dio.d_t_avanade_2025.controller.exception;

/**
 * Exceção lançada quando um usuário não é encontrado no sistema.
 */
public class UserNotFoundException extends RuntimeException {
    // Adicione o serialVersionUID
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String message) {
        super(message);
    }
}
