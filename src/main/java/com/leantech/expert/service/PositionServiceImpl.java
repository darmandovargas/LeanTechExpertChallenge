package com.leantech.expert.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leantech.expert.model.Position;
import com.leantech.expert.repository.PositionRepository;

@Service
public class PositionServiceImpl implements PositionService{

	@Autowired
	private PositionRepository positionRepo;
	
	@Override
	public List<Position> findAll() {
		return positionRepo.findAll();
	}
}
