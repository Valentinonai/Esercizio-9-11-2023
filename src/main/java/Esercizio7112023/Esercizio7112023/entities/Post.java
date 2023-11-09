package Esercizio7112023.Esercizio7112023.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record Post (
        @NotEmpty(message = "Stringa vuota non ammessa")
         String categoria,
        @NotEmpty(message = "Stringa vuota non ammessa")
         String titolo,
        @NotEmpty(message = "Stringa vuota non ammessa")
         String cover,
        @NotEmpty(message = "Stringa vuota non ammessa")
         String contenuto,
         @Min(value = 1,message = "Tempo di lettura minimo 1 minuto")
         int tempoDiLettura,
         int autore_id
){

}
