package Esercizio7112023.Esercizio7112023.services;

import Esercizio7112023.Esercizio7112023.entities.Autore;

import Esercizio7112023.Esercizio7112023.exceptions.NotFoundException;
import Esercizio7112023.Esercizio7112023.repositories.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutoreService {

@Autowired
private AutoreRepository autoreRepository;

    public Page<Autore> getAllAuthors(int page,int size,String orderby) {
        Pageable p= PageRequest.of(page,size, Sort.by(orderby));
        return autoreRepository.findAll(p);
    }

    public Autore getSingleAuthor(int id) throws NotFoundException {
        return autoreRepository.findById(id).orElseThrow(()->new NotFoundException("Elemento non trovato"));
    }


    public Autore saveNewAuthor(Autore a)  {
        a.setAvatar("https://ui-avatars.com/api/?name="+a.getNome()+"+"+a.getCognome());
        return autoreRepository.save(a);


    }

    public Autore modifyAuthor(Autore a,int id)  {
        Autore current=this.getSingleAuthor(id);
        current.setNome(a.getNome());
        current.setCognome(a.getCognome());
        current.setDataDiNascita(a.getDataDiNascita());
        current.setEmail(a.getEmail());
        current.setAvatar("https://ui-avatars.com/api/?name="+a.getNome()+"+"+a.getCognome());
        return autoreRepository.save(current);
    }

    public void deleteSingleAuthor(int id)  {
        Autore current=this.getSingleAuthor(id);
        autoreRepository.delete(current);
    }
}
