package com.project.library.service;

import com.project.library.constants.Constants;
import com.project.library.dto.ReviewDto;
import com.project.library.exception.ReviewNotFoundException;
import com.project.library.mapper.ReviewMapper;
import com.project.library.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImplementation implements GenericService<ReviewDto>{

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public ReviewDto add(ReviewDto reviewDto) {
        return reviewMapper.mapToDto(reviewRepository.save(reviewMapper.mapToClass(reviewDto)));
    }

    public List<ReviewDto> getReviewByClient_LastName(String lastName) {
        List<ReviewDto> reviewDtos = reviewRepository.findByClient_LastName(lastName).stream()
                .map(review -> reviewMapper.mapToDto(review)).collect(Collectors.toList());
        if (reviewDtos.isEmpty()) {
            throw new ReviewNotFoundException(Constants.NO_REVIEW_FOUND);
        }
        return reviewDtos;
    }

    public List<ReviewDto> getReviewByBook_Title(String title) {
        List<ReviewDto> reviewDtos = reviewRepository.findByBook_Title(title).stream()
                .map(review -> reviewMapper.mapToDto(review)).collect(Collectors.toList());
        if (reviewDtos.isEmpty()) {
            throw new ReviewNotFoundException(Constants.NO_REVIEW_FOUND);
        }
        return reviewDtos;
    }
}
