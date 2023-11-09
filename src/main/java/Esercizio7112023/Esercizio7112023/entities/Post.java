package Esercizio7112023.Esercizio7112023.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Post{
    @NotEmpty(message = "Stringa vuota non ammessa per categoria")
    private String categoria;
    @NotEmpty(message = "Stringa vuota non ammessa per titolo")
    private String titolo;
    @NotEmpty(message = "Stringa vuota non ammessa per contenuto")
    private String contenuto;
    @Min(value = 1,message = "Tempo di letturavalore minimo 1 minuto")
    private int tempoDiLettura;
    @Min(value = 1,message = "Seleziona id utente")
    private int autore_id;
}
