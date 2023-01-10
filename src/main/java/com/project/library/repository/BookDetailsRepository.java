package com.project.library.repository;

import com.project.library.entity.Author;
import com.project.library.entity.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailsRepository extends JpaRepository<BookDetails, Long> {

    BookDetails findByBookDetailsId(int id);

}
