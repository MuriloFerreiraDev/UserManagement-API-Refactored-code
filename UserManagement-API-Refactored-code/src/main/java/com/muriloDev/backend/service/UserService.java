package com.muriloDev.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.muriloDev.backend.dto.UserCreateDTO;
import com.muriloDev.backend.dto.UserNameDTO;
import com.muriloDev.backend.dto.UserUpdateDTO;
import com.muriloDev.backend.model.User;
import com.muriloDev.backend.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Cadastrar usuário
    @Transactional
    public User registerUser(UserCreateDTO dto) {
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        return userRepository.save(user);
    }

    // Buscar todos os usuários (só dados básicos)
    public List<UserNameDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(u -> new UserNameDTO(u.getName(), u.getEmail(), u.getId()))
                .collect(Collectors.toList());
    }

    // Atualizar usuário (usando DTO tipado)
    @Transactional
    public void updateUser(Long id, UserUpdateDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        if (dto.name() != null) user.setName(dto.name());
        if (dto.email() != null) user.setEmail(dto.email());

        userRepository.save(user);
    }

    // Deletar usuário
    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado com ID: " + id);
        }
        userRepository.deleteById(id);
    }
}