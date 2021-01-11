package com.example.quizsys.logging;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class ExceptionLogAdvice {

    private static  final Logger LOG = Logger.getLogger(ExceptionLogAdvice.class.getName()); //singleton pattern

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleValidationException(final Exception ex) {
        LOG.log(Level.SEVERE, null, ex);
        return "ooops: 500 - INTERNAL SERVER ERROR - happened";
    }
}
