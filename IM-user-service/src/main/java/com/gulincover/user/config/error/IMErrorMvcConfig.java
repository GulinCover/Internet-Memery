package com.gulincover.user.config.error;

import com.gulincover.api.HttpStateCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice
public class IMErrorMvcConfig {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleError(HttpServletRequest req, Exception e) {
        System.out.println(req.getRemoteAddr());
        System.out.println(e.getMessage());
        return HttpStateCode.NOT_FOUND.toString();
    }
}
