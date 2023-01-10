package com.project.library.repository;

import com.project.library.entity.Address;
import com.project.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByLastName(String firstName);

    Author findByAuthorId(int id);

    @Query("SELECT a from Author a")
    List<Author> findAll();

}
