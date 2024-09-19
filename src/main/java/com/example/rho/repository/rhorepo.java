package com.example.rho.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rho.model.RhoUsers;

public interface rhorepo extends JpaRepository<RhoUsers,Integer>{

	Optional<RhoUsers> findByEmail(String email);

}