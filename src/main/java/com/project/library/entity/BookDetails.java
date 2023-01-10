package com.project.library.entity;


import lombok.*;
import javax.persistence.*;
@Entity
@Table(name = "book_details")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
public class BookDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookDetailsId;

    @Column(name = "description")
    private String description;

    @Column(name = "publishing_year")
    private int publishingYear;

    @Column(name = "no_of_pages")
    public int noOfPages;
}
