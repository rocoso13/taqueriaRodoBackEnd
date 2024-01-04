package com.example.demo.dto;


import com.example.demo.util.Meta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ApiResponseDTO
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponseDTO {

	private Meta meta;
	private Object data;

}
