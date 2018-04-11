package com.indra.ar.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indra.ar.books.entities.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long>{

}
