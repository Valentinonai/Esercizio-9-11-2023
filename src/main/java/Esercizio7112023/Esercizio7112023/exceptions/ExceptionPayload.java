package Esercizio7112023.Esercizio7112023.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ExceptionPayload {
    private String message;
    private Date data_creazione;
}
