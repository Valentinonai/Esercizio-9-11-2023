package Esercizio7112023.Esercizio7112023.services;

import Esercizio7112023.Esercizio7112023.entities.Autore;
import Esercizio7112023.Esercizio7112023.entities.BlogPost;

import Esercizio7112023.Esercizio7112023.entities.Post;
import Esercizio7112023.Esercizio7112023.exceptions.NotFoundException;
import Esercizio7112023.Esercizio7112023.repositories.AutoreRepository;
import Esercizio7112023.Esercizio7112023.repositories.BlogPostRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class BlogPostService {

@Autowired
private BlogPostRepository blogPostRepository;
@Autowired
private AutoreRepository autoreRepository;
@Autowired
private Cloudinary cloudinary;
@Autowired
EmailService emailService;

    @Value("${spring.mail.receiver}")
    private String email;

    public Page<BlogPost> getAllBlogPosts(int page,int size,String orderby){
        Pageable p= PageRequest.of(page,size, Sort.by(orderby));
        return blogPostRepository.findAll(p);
    }


    public BlogPost getSingleBlogPost(int id) {
        return blogPostRepository.findById(id).orElseThrow(()->new NotFoundException("Elemento non trovato"));
    }

    public BlogPost saveNewPost(Post p){
        Autore a=autoreRepository.findById(p.getAutore_id()).orElseThrow(()->new NotFoundException("Autore inesistente"));
        BlogPost app= BlogPost.builder().categoria(p.getCategoria()).Titolo(p.getTitolo()).contenuto(p.getContenuto()).tempoDiLettura(p.getTempoDiLettura()).autore(a).cover("https://picsum.photos/200/300").build();
       BlogPost b= blogPostRepository.save(app);
        emailService.sendEmail(email,"BlogPost Creato"," BlogPost "+b.getId()+" creato con successo");
        return b;

    }

    public BlogPost modifyBlogPost(Post p,int id) throws IOException {
      BlogPost current=this.getSingleBlogPost(id);
        current.setCategoria(p.getCategoria());
        current.setTitolo(p.getTitolo());
        current.setContenuto(p.getContenuto());
        current.setTempoDiLettura(p.getTempoDiLettura());
        return blogPostRepository.save(current);
    }

    public void deleteSingleBlogPost(int id) throws IOException {
       BlogPost current=this.getSingleBlogPost(id);
        blogPostRepository.delete(current);
    }

    public String upload(MultipartFile file,int id) throws IOException {
        BlogPost b=this.getSingleBlogPost(id);
        String url=(String)cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
        b.setCover(url);
        blogPostRepository.save(b);
        return "Upload immagine cover eseguito";
    }
}






