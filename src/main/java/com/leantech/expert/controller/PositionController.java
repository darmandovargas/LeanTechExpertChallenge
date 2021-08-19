package com.leantech.expert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.leantech.expert.model.Position;
import com.leantech.expert.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/position")
@Api(value="TCloudG Expert REST API for LeanTech")
public class PositionController {
	@Autowired
	private PositionService positionService;
	
	@ApiOperation(value="List of Positions", response = List.class)
	@ApiResponses(value= {@ApiResponse(code=200, message="Successfully listed")})
	@GetMapping("")
	public List<Position> findEmployee(){
		return positionService.findAll();
	}
}
