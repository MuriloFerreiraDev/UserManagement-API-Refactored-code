package com.muriloDev.backend.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.muriloDev.backend.dto.*;
import com.muriloDev.backend.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponseDTO> registerUser(@Valid @RequestBody UserCreateDTO dto, HttpServletRequest request) {
        userService.registerUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponseDTO(HttpStatus.CREATED.value(), "Usuário registrado com sucesso!", request.getRequestURI()));
    }

    @GetMapping("/read")
    public ResponseEntity<?> getAllUsers(HttpServletRequest request) {
        List<UserNameDTO> users = userService.getAllUsers();

        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new ApiResponseDTO(HttpStatus.NO_CONTENT.value(), "Nenhum usuário encontrado.", request.getRequestURI()));
        }

        return ResponseEntity.ok(users);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ApiResponseDTO> updateUser(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO dto, HttpServletRequest request) {
        userService.updateUser(id, dto);
        return ResponseEntity.ok(new ApiResponseDTO(HttpStatus.OK.value(), "Usuário atualizado com sucesso!", request.getRequestURI()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> deleteUser(@PathVariable Long id, HttpServletRequest request) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new ApiResponseDTO(HttpStatus.OK.value(), "Usuário deletado com sucesso!", request.getRequestURI()));
    }
}
