package com.project.library.mapper;

import com.project.library.dto.ReturnHistoryDto;
import com.project.library.entity.ReturnHistory;

public class ReturnHistoryMapper implements GenericMapper<ReturnHistory, ReturnHistoryDto> {
    @Override
    public ReturnHistory mapToClass(ReturnHistoryDto returnHistoryDto) {
        return ReturnHistory.builder()
                .returnDate(returnHistoryDto.getReturnDate())
                .borrowHistory(returnHistoryDto.getBorrowHistory())
                .build();
    }

    @Override
    public ReturnHistoryDto mapToDto(ReturnHistory returnHistory) {
        return ReturnHistoryDto.builder()
                .returnId(returnHistory.getReturnId())
                .returnDate(returnHistory.getReturnDate())
                .borrowHistory(returnHistory.getBorrowHistory())
                .build();
    }
}
