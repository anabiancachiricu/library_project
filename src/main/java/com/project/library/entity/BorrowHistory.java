package com.project.library.entity;


import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "borrows")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
public class BorrowHistory {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int borrowHistoryId;


   @ManyToOne
   @JoinColumn(name="client_id")
   private Client client;

   @OneToOne
   @JoinColumn(name = "book_id")
   private Book book;

   @Column(name = "date")
   private Date date;

}
