package com.tistory.cookeat.cookeating.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {


    /**
     * error는 List<String>에 담아서 리턴한다.
     *
     * ex)
     *  List<String> list = new ArrayList<>();
     *  list.add("에러필드");
     *  list.add("에러메시지");
     *
     */
    //Todo : 403, 404, 500 에러 페이지(html) 작성 후 코드 작성


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {

        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();

        List<String> errorList = new ArrayList<>();
        allErrors.forEach(objectError -> {
            FieldError fieldError = (FieldError) objectError;
            errorList.add(fieldError.getField());
            errorList.add(fieldError.getDefaultMessage());
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
    }




}
