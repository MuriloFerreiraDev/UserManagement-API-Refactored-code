package com.muriloDev.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name="users")
public class User {
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "O nome é obrigatório.")
	@Size(min = 3, max = 150, message = "O nome deve ter entre 3 e 150 caracteres.")
	private String name;

	@Column(nullable = false, unique = true)
	@NotBlank(message = "O e-mail é obrigatório.")
	@Email(message = "O e-mail informado é inválido.")
	private String email;

	@Column(nullable = false)
	@NotBlank(message = "A senha é obrigatória.")
	@Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
	private String password;
}
