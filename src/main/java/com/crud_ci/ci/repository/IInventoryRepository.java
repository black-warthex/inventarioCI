package com.crud_ci.ci.repository;

import com.crud_ci.ci.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventoryRepository extends JpaRepository<InventoryEntity, String> {

}
