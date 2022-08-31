package com.example.bcistern.service;

import com.example.bcistern.dao.InventoryRepository;
import com.example.bcistern.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public void getCourse(Inventory inventory){
        inventory.setDate_added(LocalDateTime.now());
        this.inventoryRepository.save(inventory);
    }

    public Optional<List<Inventory>> showUserInventory(Long uid){
        return inventoryRepository.findInvByUser(uid);
    }

    public Optional<Inventory> findThatInv(Long uid, Long cid){
        return inventoryRepository.FindThatInv(uid, cid);
    }

    public List<Inventory> showCourseOwners(Long cid){
        return inventoryRepository.findInvByCourse(cid);
    }

}
