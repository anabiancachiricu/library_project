package com.project.library.entity;

import lombok.*;
import org.w3c.dom.stylesheets.LinkStyle;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libraries")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int libraryId;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany
    @JoinTable(name = "library_book", joinColumns = @JoinColumn(name = "library_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> bookList=new ArrayList<>();

}
