package com.example.demo.error;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static lombok.AccessLevel.PRIVATE;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


import lombok.RequiredArgsConstructor;

@JsonAutoDetect(fieldVisibility = ANY)
@RequiredArgsConstructor(access=PRIVATE)
public class ErrorResponse {
	private final int statusCode;
	private final List<ApiError> errors;
	
	ErrorResponse(int statusCode, List<ApiError> errors){
		this.statusCode = statusCode;
		this.errors = errors;
	}
	
	static ErrorResponse of(HttpStatus status, List<ApiError> errors) {
		return new ErrorResponse(status.value(), errors);
	}
	
	static ErrorResponse of(HttpStatus status, ApiError error) {
		return of(status, Collections.singletonList(error));
	}
	
	
	@JsonAutoDetect(fieldVisibility = ANY)
	@RequiredArgsConstructor
	static class ApiError{
		private final String code;
		private final String message;
		
//		ApiError(String code, String message) {
//			this.code = code;
//			this.message = message;
//		}
	}

}
