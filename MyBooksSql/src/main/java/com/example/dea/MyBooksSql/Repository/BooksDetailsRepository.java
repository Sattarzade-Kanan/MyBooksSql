package com.example.dea.MyBooksSql.Repository;

import com.example.dea.MyBooksSql.Entity.BooksDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksDetailsRepository extends JpaRepository<BooksDetails ,Integer> {
}
