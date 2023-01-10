package com.project.library.entity;

import jdk.jfr.Description;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.management.Descriptor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
@Entity
@Table(name = "books")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "author", nullable=false)
    @JsonIgnore
    private Author author;

    @OneToOne
    @JoinColumn(name = "book_details_id")
    private BookDetails bookdetails;

    @ManyToMany(mappedBy = "bookList")
    @JsonIgnore
    private List<Library> libraries = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<Review> reviewListBook=new ArrayList<>();
}
