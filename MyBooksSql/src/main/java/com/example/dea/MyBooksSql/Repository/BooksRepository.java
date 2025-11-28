package com.example.dea.MyBooksSql.Repository;

import com.example.dea.MyBooksSql.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {
    List<Books> getaLLBooksByAuthor(String author);
    List<Books> getAllBooksByPrice(Double price);
    List<Books> getAllBooksByName(String name);

}
