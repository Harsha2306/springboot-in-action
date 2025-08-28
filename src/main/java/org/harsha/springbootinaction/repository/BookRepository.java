package org.harsha.springbootinaction.repository;

import java.util.List;
import org.harsha.springbootinaction.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
  List<Book> findByReader(String reader);
}
