package com.project.library.entity;
import lombok.*;
import javax.persistence.*;
import javax.persistence.*;

@Entity
@Table(name = "reviews")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @Column(name = "review_text")
    private String reviewText;

    @Column(name = "review_grade")
    private float reviewGrade;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


}
