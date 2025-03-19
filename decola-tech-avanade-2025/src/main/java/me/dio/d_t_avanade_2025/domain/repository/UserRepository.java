package me.dio.d_t_avanade_2025.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.d_t_avanade_2025.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}


