package me.dio.decola_tech_avanade_2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.decola_tech_avanade_2025.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}


