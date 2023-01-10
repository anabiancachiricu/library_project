package com.project.library.mapper;

import com.project.library.dto.BorrowHistoryDto;
import com.project.library.entity.BorrowHistory;

public class BorrowHistoryMapper implements GenericMapper<BorrowHistory, BorrowHistoryDto> {


    public BorrowHistory mapToClass(BorrowHistoryDto borrowHistoryDto) {
        return BorrowHistory.builder()
                .book(borrowHistoryDto.getBook())
                .client(borrowHistoryDto.getClient())
                .date(borrowHistoryDto.getDate())
                .build();
    }

    public BorrowHistoryDto mapToDto(BorrowHistory borrowHistory) {
        return BorrowHistoryDto.builder()
                .borrowHistoryId(borrowHistory.getBorrowHistoryId())
                .book(borrowHistory.getBook())
                .client(borrowHistory.getClient())
                .date(borrowHistory.getDate())
                .build();
    }
}
