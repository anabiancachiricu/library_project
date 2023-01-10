package com.project.library.entity;


import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;
import javax.persistence.*;
@Entity
@Table(name = "authors")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @OneToMany (mappedBy = "author", cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
    @JsonIgnore
    private List<Book> books;
}
