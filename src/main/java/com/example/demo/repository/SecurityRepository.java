package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Security;

public interface SecurityRepository extends JpaRepository<Security, Long> {

	Security findByUserId(Long userId);

	Security findByEmail(String email);

	Security findByConfirmationToken(String name);

	Security findByPassword(String password);
}
