package Esercizio7112023.Esercizio7112023.repositories;

import Esercizio7112023.Esercizio7112023.entities.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreRepository extends JpaRepository<Autore,Integer>{
}
