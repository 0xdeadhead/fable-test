package com.fable.task_management.exception_handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fable.task_management.dto.ErrorResponseDTO;
import com.fable.task_management.exception.BusinessException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    private ResponseEntity<ErrorResponseDTO> businessExceptionCallBack(BusinessException businessException) {
        return ResponseEntity.status(businessException.getStatus())
                .body(ErrorResponseDTO.builder().message(businessException.getMessage()).build());

    }
}
