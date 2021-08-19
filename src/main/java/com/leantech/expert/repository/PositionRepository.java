package com.leantech.expert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.leantech.expert.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long>{
	
}
