package com.example.sample.dao.db2;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sample.entity.db2.AppleEntity;

@Repository
public interface AppleDao extends JpaRepository<AppleEntity, String>{

	Optional<AppleEntity> findById(String id);
}
