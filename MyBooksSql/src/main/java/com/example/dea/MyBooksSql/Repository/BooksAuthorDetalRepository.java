package com.example.dea.MyBooksSql.Repository;

import com.example.dea.MyBooksSql.Entity.BooksAuthorDetails;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksAuthorDetalRepository extends JpaRepository<BooksAuthorDetails, Integer> {
}
