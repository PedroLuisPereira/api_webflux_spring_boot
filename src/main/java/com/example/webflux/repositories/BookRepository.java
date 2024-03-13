package com.example.webflux.repositories;


import com.example.webflux.models.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BookRepository extends ReactiveCrudRepository<Book,Long> {
}