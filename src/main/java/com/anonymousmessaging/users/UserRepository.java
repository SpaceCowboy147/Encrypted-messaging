package com.anonymousmessaging.users;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    void registerNewUser(String username, String password);
String findByUserName(String username);
}
