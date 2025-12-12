package com.example.dea.MyBooksSql.Service;

import com.example.dea.MyBooksSql.Entity.BooksDetails;
import com.example.dea.MyBooksSql.Repository.BooksDetailsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BooksDetailsService {
    private final BooksDetailsRepository booksDetailsRepository;

    public BooksDetailsService(BooksDetailsRepository booksDetailsRepository) {
        this.booksDetailsRepository = booksDetailsRepository;
    }
      public List<BooksDetails> getALLDetails() {
        return booksDetailsRepository.findAll();
      }
        public BooksDetails getBookDetails(@PathVariable Integer id){
           return booksDetailsRepository.findById(id).orElseThrow(() -> new RuntimeException("Error Code"));
        }

        public BooksDetails addNewDetails(@RequestBody BooksDetails newDetails){
        return booksDetailsRepository.save(newDetails);
        }
}
