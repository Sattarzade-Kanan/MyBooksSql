package com.example.dea.MyBooksSql.Service;

import com.example.dea.MyBooksSql.Entity.BooksAuthorDetails;
import com.example.dea.MyBooksSql.Repository.BooksAuthorDetalRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BooksAuthorDetService {
    private final BooksAuthorDetalRepository booksAuthorDetalRepository;

    public BooksAuthorDetService(BooksAuthorDetalRepository booksAuthorDetalRepository) {
        this.booksAuthorDetalRepository = booksAuthorDetalRepository;
    }
    public List<BooksAuthorDetails> getAllAuthor(){
        return booksAuthorDetalRepository.findAll();
    }
    public BooksAuthorDetails getAuthorDetails(@PathVariable Integer id){
        return booksAuthorDetalRepository.findById(id).orElseThrow(()-> new RuntimeException("Error"));
    }
    public BooksAuthorDetails updateDetails(@PathVariable Integer id, @RequestBody BooksAuthorDetails updatedDetails){
        return booksAuthorDetalRepository.findById(id).map(exsisting -> {
            exsisting.setName(updatedDetails.getName());
            exsisting.setSurName(updatedDetails.getSurName());
            exsisting.setAge(updatedDetails.getAge());
        }).orElseThrow(() -> new RuntimeException("Error"))
 ;   }
    
}
