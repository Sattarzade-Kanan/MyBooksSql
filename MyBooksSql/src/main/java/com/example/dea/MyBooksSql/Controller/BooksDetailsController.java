package com.example.dea.MyBooksSql.Controller;

import com.example.dea.MyBooksSql.Entity.BooksDetails;
import com.example.dea.MyBooksSql.Service.BooksDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
public class BooksDetailsController {
    private final BooksDetailsService booksDetailsService;

    public BooksDetailsController(BooksDetailsService booksDetailsService) {
        this.booksDetailsService = booksDetailsService;
    }
    @GetMapping("/all")
    public List<BooksDetails> getAllDetails(){
        return booksDetailsService.getALLDetails();
    }
    @GetMapping("/{id}")
    public BooksDetails getDetails(@PathVariable Integer id){
        return booksDetailsService.getBookDetails(id);
    }
    @PostMapping("/{id}")
    public BooksDetails addDetails(@RequestBody BooksDetails newDetails){
        return booksDetailsService.addNewDetails(newDetails);
    }
}
