package com.example.dea.MyBooksSql.Repository;

import com.example.dea.MyBooksSql.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {
    @Query(value = "SELECT * FROM books1 WHERE price >= :minPrice", nativeQuery = true)

    List<Books> getAllBooksByPrice(Double minPrice);
    @Query(value = "SELECT * FROM books1 WHERE LOWER(author) LIKE LOWER(CONCAT('%' :author ,'%')" , nativeQuery = true)
    List<Books> getaLLBooksByAuthor(String author);

    @Query(value = "SELECT * FROM books1 WHERE LOWER(name) LIKE LOWER(CONCAT('%' :name,'%')", nativeQuery = true)
    List<Books> getAllBooksByName(String name);
}
