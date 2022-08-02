package com.example.bcistern.dao;

import com.example.bcistern.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>
{

    @Query("SELECT s from User s where s.email = ?1")
    Optional<User> findUserByEmail(String email);

    @Query("SELECT s from User s where s.id = ?1")
    Optional<User> findUserById(Long id);

    @Query("delete from User s where s.id = ?1")
    void deleteUserById(Long id);
}
