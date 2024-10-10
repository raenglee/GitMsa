package com.example.org.error;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.Arrays;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> sqlIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(e.getMessage())
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity
                .status(errorResponse.getHttpStatus())
                .body(errorResponse);
    }

    @ExceptionHandler(BizException.class)
    public ResponseEntity<ErrorResponse> mException(BizException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(e.getErrorCode().getMessage())
                .httpStatus(e.getErrorCode().getHttpStatus())
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity
                .status(errorResponse.getHttpStatus())
                .body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)  //밸리데이션에러
    public ResponseEntity<ErrorResponse> validityException(MethodArgumentNotValidException e) {

        String msg = (String) Arrays.stream(e.getDetailMessageArguments())
                .reduce("", (s, s2) -> s.toString() + s2.toString());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message(msg)
                .localDateTime(LocalDateTime.now())
                .build();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(ConstraintViolationException.class)

    public ResponseEntity<ErrorResponse> constraintException(ConstraintViolationException e) {

        //stream
        String msg = e.getConstraintViolations()
                .stream()
                .map(constraintViolation -> constraintViolation.getMessage())
                .reduce("",(s, s2) -> s+s2);

        //향상된 for구문
//        Set<ConstraintViolation<?>> set = e.getConstraintViolations();  //위배된것이 set으로 들어가고
//
//        String test = "";
//        for(ConstraintViolation<?> item:set){  //set에 있는 위배된  요소를 가져옴
//            System.out.println(item);
//            System.out.println(item.getMessage());
//            test = item.getMessage();
//        }

        ErrorResponse errorResponse = ErrorResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message(msg)
                .localDateTime(LocalDateTime.now())
                .build();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }
}