package me.dio.d_t_avanade_2025.service.impl;

import me.dio.d_t_avanade_2025.controller.exception.UserNotFoundException;
import me.dio.d_t_avanade_2025.domain.model.User;
import me.dio.d_t_avanade_2025.domain.repository.UserRepository;
import me.dio.d_t_avanade_2025.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user); // Salvando o usuário no banco
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll(); // Buscando todos os usuários
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id); // Buscando usuário por ID
	}

	@Override
	public User updateUser(Long id, User user) {
		return userRepository.findById(id).map(existingUser -> {
			user.setId(existingUser.getId());
			return userRepository.save(user);
		}).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado com o ID: " + id));
	}

	@Override
	public void deleteUser(Long id) {
		if (userRepository.existsById(id)) {
			throw new RuntimeException("Usuário não encontrado com o ID: " + id);
		}
		userRepository.deleteById(id); // Excluindo o usuário
	}
}
