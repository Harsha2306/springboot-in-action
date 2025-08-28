package org.harsha.springbootinaction.mapper;

import org.harsha.springbootinaction.dto.BookRequestDto;
import org.harsha.springbootinaction.dto.BookResponseDto;
import org.harsha.springbootinaction.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
  public BookResponseDto mapToBookResponseDto(Book book) {
    return BookResponseDto.builder()
        .id(book.getId())
        .title(book.getTitle())
        .isbn(book.getIsbn())
        .author(book.getAuthor())
        .reader(book.getReader())
        .description(book.getDescription())
        .build();
  }

  public Book mapToBook(BookRequestDto bookRequestDto) {
    return Book.builder()
        .author(bookRequestDto.author())
        .description(bookRequestDto.description())
        .isbn(bookRequestDto.isbn())
        .reader(bookRequestDto.reader())
        .title(bookRequestDto.title())
        .build();
  }
}
