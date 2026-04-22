package com.scheduledevelop.user.controller;

import com.scheduledevelop.user.entity.User;
import com.scheduledevelop.user.service.UserService;
import com.scheduledevelop.user.dtos.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid CreateUserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(request));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<GetUserResponse> findOneUser(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findOne(id));
    }

    @GetMapping("/users")
    public ResponseEntity<List<GetUserResponse>> findOneUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UpdateUserResponse> updateUser(@RequestBody UpdateUserRequest request, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(request, id));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/users/login")
    public LoginResponse login(@RequestBody LoginRequest request, HttpSession session) {

        User user = userService.login(request.getEmail(), request.getPassword());
        session.setAttribute("LOGIN_USER", user.getId());

        return new LoginResponse(user.getId(), "로그인 성공");
    }
}
