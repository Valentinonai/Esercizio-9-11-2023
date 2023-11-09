package Esercizio7112023.Esercizio7112023.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(BadRequest.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionPayload badRequest(BadRequest e){
        return new ExceptionPayload(e.getMessage(),new Date());
    }
@ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionPayload notFoundMethod(NotFoundException e){
    return new ExceptionPayload(e.getMessage(),new Date());
}
@ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionPayload internalError(Exception e){
    e.printStackTrace();
    return  new ExceptionPayload("Internal-server-error",new Date());
}
}
