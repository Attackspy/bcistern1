package com.example.bcistern.dao;

import com.example.bcistern.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Query("SELECT i from Inventory i where i.user.id = ?1")
    Optional<List<Inventory>> findInvByUser(Long uid);

    @Query("SELECT i from Inventory i where i.user.id =?1 and i.course.id = ?2")
    Optional<Inventory> FindThatInv(Long uid, Long cid);

    @Query("SELECT i from Inventory i where i.course.id =?1")
    List<Inventory> findInvByCourse(Long cid);
}
