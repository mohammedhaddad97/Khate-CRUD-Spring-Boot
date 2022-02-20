package com.example.Khatera;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserClass, Long> {

    Optional<UserClass> findUserByUsername(String username);
}
