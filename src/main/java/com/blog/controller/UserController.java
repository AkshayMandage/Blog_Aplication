package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.UserDto;
import com.blog.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// Add User api
	@PostMapping
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createUserDto = userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}

	// update User api
	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer id) {
		UserDto userDto2 = userService.updateUser(userDto, id);
		return ResponseEntity.ok(userDto2);
	}

	// delete user api
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponse> deletUser(@PathVariable Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully...", true), HttpStatus.OK);
	}

	// Get user api
	@GetMapping("{id}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}

	// Get All User
	@GetMapping()
	public ResponseEntity<List<UserDto>> getAllUser() {
		return ResponseEntity.ok(userService.getAllUser());
	}
        
}
