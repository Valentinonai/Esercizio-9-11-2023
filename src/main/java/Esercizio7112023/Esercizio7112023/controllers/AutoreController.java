package Esercizio7112023.Esercizio7112023.controllers;

import Esercizio7112023.Esercizio7112023.entities.Autore;
import Esercizio7112023.Esercizio7112023.entities.BlogPost;
import Esercizio7112023.Esercizio7112023.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AutoreController {

    @Autowired
    AutoreService autoreService;
    @GetMapping()
    public Page<Autore> getAllAuthors(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10")int size, @RequestParam(defaultValue = "id")String orderby){
            return autoreService.getAllAuthors(page,size>20?10:size,orderby);
    }
    @GetMapping("/{id}")
    public Autore getSingleAuthor(@PathVariable int id){
        return autoreService.getSingleAuthor(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Autore saveNewAuthor(@RequestBody Autore a) {
        return autoreService.saveNewAuthor(a);
    }

    @PutMapping("/{id}")
    public Autore modifyAuthor(@RequestBody Autore a,@PathVariable int id)  {
        return autoreService.modifyAuthor(a,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSingleAuthor(@PathVariable int id)  {
        autoreService.deleteSingleAuthor(id);
    }
}
