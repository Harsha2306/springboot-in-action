package org.harsha.springbootinaction.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.harsha.springbootinaction.dto.BookRequestDto;
import org.harsha.springbootinaction.dto.BookResponseDto;
import org.harsha.springbootinaction.mapper.BookMapper;
import org.harsha.springbootinaction.repository.BookRepository;
import org.harsha.springbootinaction.service.IBookService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService implements IBookService {
  private final BookRepository bookRepository;

  private final BookMapper bookMapper;

  @Override
  public List<BookResponseDto> getBooksByReader(String reader) {
    log.info("getting books by reader:{}", reader);
    return bookRepository.findByReader(reader).stream()
        .map(bookMapper::mapToBookResponseDto)
        .toList();
  }

  public void addBook(BookRequestDto bookRequestDto) {
    log.info("saving book:{}", bookRequestDto);
    bookRepository.save(bookMapper.mapToBook(bookRequestDto));
  }
}
