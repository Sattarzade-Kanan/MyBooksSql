package com.example.dea.MyBooksSql.Service;

import com.example.dea.MyBooksSql.Entity.Books;
import com.example.dea.MyBooksSql.Repository.BooksRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }
    //Find Methods
    public List<Books > getAllBooksByAuthor(String author) {
        return booksRepository.getaLLBooksByAuthor( author);
    }

    public List<Books > getAllBooksByName(String name) {
        return booksRepository.getAllBooksByName( name);
    }

    public List<Books > getAllBooksByPrice(Double minPrice) {
        return booksRepository.getAllBooksByPrice(minPrice);
    }
    /// Сначало срабатывает класс ентитй после этоко репозиторй а потом сервисе и контроллер
    /// --=
    /// 00
    /// --
    /// --
    /// ----
    ///
    ///
    //Methods
    public List<Books> getAllBooks(){
        return booksRepository.findAll();
    }

    public Books addBook(@RequestBody Books newBook){
        return booksRepository.save(newBook);
    }
    public String deleteBook(@PathVariable Integer id){
        if (booksRepository.existsById(id)){
            booksRepository.deleteById(id);
            return "Book Deleted";
        }
        return "Error";
    }
    public Books getBook(@PathVariable Integer id){
        return booksRepository.findById(id).orElseThrow(() -> new RuntimeException("Error Id " + id + "Does not exsist"));


    }
    public Books updateBooks(@PathVariable Integer id , @RequestBody Books updatedBook){

       return booksRepository.findById(id).map(exsisting ->{exsisting.setName(updatedBook.getName());
       exsisting.setAuthor(updatedBook.getAuthor())
       ;
       exsisting.setPrice(updatedBook.getPrice());
       exsisting.setTitle(updatedBook.getTitle());
       return  booksRepository.save(updatedBook);
       })
               .orElseThrow(() -> new RuntimeException("Error"));
    }
}
