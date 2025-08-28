package org.harsha.springbootinaction.service;

import java.util.List;
import org.harsha.springbootinaction.dto.BookRequestDto;
import org.harsha.springbootinaction.dto.BookResponseDto;

public interface IBookService {
  List<BookResponseDto> getBooksByReader(String reader);

  void addBook(BookRequestDto bookRequestDto);
}
