package com.nv.foodapp.exception;

import java.time.LocalDateTime;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nv.foodapp.dto.ExceptionResponseDTO;



@ControllerAdvice
public class CommonExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ExceptionResponseDTO> doSomeThings(EntityNotFoundException e)
	{
		ExceptionResponseDTO dto = new ExceptionResponseDTO();
		dto.setErrorMsg(e.getMessage());
		dto.setDateTime(LocalDateTime.now()+"");
		return new ResponseEntity<ExceptionResponseDTO>(dto,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionResponseDTO> doSomeThingForFieldsInput(InvalidInputDataException e)
	{
		ExceptionResponseDTO dto = new ExceptionResponseDTO();
		dto.setErrorMsg(e.toString());
		dto.setDateTime(LocalDateTime.now()+"");
		return new ResponseEntity<ExceptionResponseDTO>(dto,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionResponseDTO> doSomeThingForNullInput(NullPointerException e)
	{
		ExceptionResponseDTO dto = new ExceptionResponseDTO();
		dto.setErrorMsg(e.toString());
		dto.setDateTime(LocalDateTime.now()+"");
		return new ResponseEntity<ExceptionResponseDTO>(dto,HttpStatus.BAD_REQUEST);
	}

}
