package com.nv.foodapp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvalidInputDataException extends Exception {

	String fieldName;
	String msg;
	@Override
	public String toString() {
		return fieldName+" "+msg;
	}
  
}
