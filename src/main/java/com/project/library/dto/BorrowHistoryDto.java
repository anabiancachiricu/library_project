package com.project.library.dto;

import com.project.library.entity.Book;
import com.project.library.entity.Client;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowHistoryDto {
    private int borrowHistoryId;
    private Client client;
    private Book book;
    private Date date;

}
