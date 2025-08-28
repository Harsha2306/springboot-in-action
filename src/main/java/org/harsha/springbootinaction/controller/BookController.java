package org.harsha.springbootinaction.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.harsha.springbootinaction.dto.BookRequestDto;
import org.harsha.springbootinaction.dto.BookResponseDto;
import org.harsha.springbootinaction.dto.SuccessResponse;
import org.harsha.springbootinaction.service.IBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
public class BookController {
  private final IBookService bookService;

  @GetMapping
  public ResponseEntity<SuccessResponse<List<BookResponseDto>>> getBooksByReader(
      @RequestParam String reader) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(new SuccessResponse<>(bookService.getBooksByReader(reader)));
  }

  @PostMapping
  public ResponseEntity<SuccessResponse<String>> addBook(
      @RequestBody @Valid BookRequestDto bookRequestDto) {
    bookService.addBook(bookRequestDto);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new SuccessResponse<>("book " + bookRequestDto.title() + " created"));
  }
}
