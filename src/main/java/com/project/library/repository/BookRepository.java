package com.project.library.repository;

import com.project.library.entity.Author;
import com.project.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);

    @Query("SELECT b from Book b")
    List<Book> findAll();

    List<Book> findBookByAuthor_LastName(String lastName);

    List<Book> findBookByTitle (String title);

    Book findBookByBookId (int id);

}
