package com.example.dea.MyBooksSql.Controller;

import com.example.dea.MyBooksSql.Entity.Books;
import com.example.dea.MyBooksSql.Service.BooksService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/books")
public class BooksController {
    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/all")
    public List<Books> getAllBooks(){
        return booksService.getAllBooks();
    }

    @PostMapping("/add")
    public Books addBook(@RequestBody Books newBook){
        return booksService.addBook(newBook);
    }

    @PutMapping("/update/{id}")
    public Books updateBook(@PathVariable Integer id , @RequestBody Books updatedBook){
        return booksService.updateBooks(id, updatedBook);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Integer id){
        return booksService.deleteBook(id);
    }

    @GetMapping("/name/{name}")
    public List<Books> getAllBooksByNAME(String name){
        return booksService.getAllBooksByName( name);
    }

    @GetMapping("/author/{author}")
    public List<Books> getAllBooksByAuthor(String author){
        return booksService.getAllBooksByAuthor( author);
    }

    @GetMapping("/price/{price}")
    public List<Books> getAllBooksByPrice(Double price){
        return booksService.getAllBooksByPrice(price);
    }

    //Pagination
    @GetMapping("/pagination")
    public Page<Books> getPagination(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5")       int size){
        return booksService.getBooksByPage(page, size);
    }

}
