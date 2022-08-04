package com.example.bcistern.dao;

import com.example.bcistern.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>
{

    @Query("SELECT u from User u where u.email = ?1")
    Optional<User> findUserByEmail(String email);

    @Modifying
    @Query("delete from User u where u.id = ?1")
    void deleteUserById(Long id);

    @Modifying
    @Query("update User u set u.last_login = ?1 where u.email = ?2")
    void userLogin(LocalDateTime date, String email);

    @Modifying
    @Query("update User u set u.money = ?1 where u.id = ?2")
    void changeMoney(double money, Long id);
}
