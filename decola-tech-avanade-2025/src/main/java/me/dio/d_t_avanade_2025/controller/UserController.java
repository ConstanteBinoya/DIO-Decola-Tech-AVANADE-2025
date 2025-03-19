package me.dio.d_t_avanade_2025.controller;

import me.dio.d_t_avanade_2025.domain.model.User;
import me.dio.d_t_avanade_2025.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users") // Define o caminho base para os endpoints
public class UserController {

	@Autowired
	private UserService userService;

	// Método para salvar um novo usuário
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED); // Retorna um 201 Created
	}

	// Método para buscar todos os usuários
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK); // Retorna um 200 OK
	}

	// Método para buscar um usuário pelo ID
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		Optional<User> user = userService.getUserById(id);
		return user.map(u -> new ResponseEntity<>(u, HttpStatus.OK)) // Se o usuário for encontrado
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Se não for encontrado
	}

	// Método para atualizar um usuário
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
		User updatedUser = userService.updateUser(id, user);
		return updatedUser != null ? new ResponseEntity<>(updatedUser, HttpStatus.OK) // Se a atualização for
																						// bem-sucedida
				: new ResponseEntity<>(HttpStatus.NOT_FOUND); // Se o usuário não for encontrado
	}

	// Método para excluir um usuário
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna um 204 No Content
	}
}
