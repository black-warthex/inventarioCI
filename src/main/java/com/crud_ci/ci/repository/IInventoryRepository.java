package com.crud_ci.ci.repository;

import com.crud_ci.ci.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IInventoryRepository extends JpaRepository<InventoryEntity, String> {
    List<InventoryEntity> findAll();
    List<InventoryEntity> findByinventoryItemName(String name);

}
