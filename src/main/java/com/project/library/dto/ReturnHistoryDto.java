package com.project.library.dto;

import com.project.library.entity.BorrowHistory;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReturnHistoryDto {

    private int returnId;
    private Date returnDate;
    private BorrowHistory borrowHistory;
}
