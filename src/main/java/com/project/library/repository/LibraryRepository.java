package com.project.library.repository;

import com.project.library.dto.LibraryDto;
import com.project.library.entity.Book;
import com.project.library.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

    Library findLibrariesByLibraryId(int id);

    @Query("SELECT l from Library l")
    List<Library> findAll();
}
