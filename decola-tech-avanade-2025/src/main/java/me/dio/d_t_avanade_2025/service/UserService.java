package me.dio.d_t_avanade_2025.service;

import me.dio.d_t_avanade_2025.domain.model.*;
import java.util.List;
import java.util.Optional;

public interface UserService {

	// Método para salvar um novo usuário
	User saveUser(User user);

	// Método para buscar todos os usuários
	List<User> getAllUsers();

	// Método para buscar um usuário pelo ID
	Optional<User> getUserById(Long id);

	// Método para atualizar um usuário
	User updateUser(Long id, User user);

	// Método para excluir um usuário
	void deleteUser(Long id);

}
