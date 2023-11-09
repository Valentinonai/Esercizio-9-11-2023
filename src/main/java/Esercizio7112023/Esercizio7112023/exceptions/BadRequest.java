package Esercizio7112023.Esercizio7112023.exceptions;

import lombok.Getter;
import org.springframework.validation.ObjectError;

import java.util.List;
@Getter
public class BadRequest extends RuntimeException{
    private List<ObjectError> errorsList;
    public BadRequest(String message) {

        super(message);


    }
    public BadRequest(List< ObjectError >errors){
            this.errorsList=errors;
    }
}
