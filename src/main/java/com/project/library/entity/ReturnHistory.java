package com.project.library.entity;


import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "returns")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ReturnHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int returnId;

    @Column(name = "return_date")
    private Date returnDate;

    @OneToOne
    @JoinColumn(name = "borrow_history_id")
    private BorrowHistory borrowHistory;

}
