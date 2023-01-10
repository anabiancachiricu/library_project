package com.project.library.repository;

import com.project.library.entity.Author;
import com.project.library.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByBook_Title(String title);
    List<Review> findByClient_LastName(String lastname);
}
