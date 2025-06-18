package com.kh.reactbackend.dto;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class PageResponse<T> {
    private List<T> posts;
    private int currentPage;
    private int totalPages;
    private long totalCount;
    private boolean hasNext;
    private boolean hasPrevious;

    public PageResponse(Page<T> posts) {
        this.posts = posts.getContent();
        this.currentPage = posts.getNumber();
        this.totalPages = posts.getTotalPages();
        this.hasNext = posts.hasNext();
        this.hasPrevious = posts.hasPrevious();
        this.totalCount = posts.getTotalElements();
    }
}
