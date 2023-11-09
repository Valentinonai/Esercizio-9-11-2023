package Esercizio7112023.Esercizio7112023.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
        private String categoria;
        private String Titolo;
        private String cover;
        private String contenuto;
        private int tempoDiLettura;
        private int autore_id;
}
