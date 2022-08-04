package com.example.bcistern.dao;

import com.example.bcistern.model.Inventory;
import com.example.bcistern.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, UUID> {

    @Query("SELECT i from Inventory i where i.user_id = ?1")
    Optional<List<Inventory>> findInvByUser(Long uid);

    @Query("SELECT i from Inventory i where i.user_id =?1 and i.course_id = ?2")
    Optional<Inventory> FindThatInv(Long uid, Long cid);
}
