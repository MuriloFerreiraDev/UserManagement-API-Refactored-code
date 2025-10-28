package com.muriloDev.backend.dto;

import java.time.LocalDateTime;

public record ApiResponseDTO(LocalDateTime timestamp, int status, String message, String path) {

	public ApiResponseDTO(int status, String message, String path) {
		this(LocalDateTime.now(), status, message, path);
	}
}
