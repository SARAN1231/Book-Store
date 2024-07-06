package com.saran.Book_store_server.Repository;

import com.saran.Book_store_server.Models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, Integer> {
}
