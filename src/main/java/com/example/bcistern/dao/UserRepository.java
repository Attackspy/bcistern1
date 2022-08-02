package com.example.bcistern.dao;

import com.example.bcistern.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>
{

    @Query("SELECT s from User s where s.email = ?1")
    Optional<User> findUserByEmail(String email);

    @Query("SELECT s from User s where s.id = ?1")
    Optional<User> findUserById(Long id);

    @Modifying
    @Query("delete from User s where s.id = ?1")
    void deleteUserById(Long id);
}
