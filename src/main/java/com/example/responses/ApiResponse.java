package com.example.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
	
	private String msg,status;
	private int statusCode;
	private boolean success;
	private List<?> body;
	
	
	public ApiResponse(String msg, String status, int statusCode, boolean success) {
		super();
		this.msg = msg;
		this.status = status;
		this.statusCode = statusCode;
		this.success = success;
	}

	
	
}
