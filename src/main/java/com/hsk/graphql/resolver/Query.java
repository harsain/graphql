package com.hsk.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hsk.graphql.model.Author;
import com.hsk.graphql.model.Book;
import com.hsk.graphql.repository.AuthorRepository;
import com.hsk.graphql.repository.BookRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {
  private BookRepository bookRepository;
  private AuthorRepository authorRepository;

  public List<Book> findAllBooks() {
    return bookRepository.findAll();
  }

  public List<Author> findAllAuthors() {
    return authorRepository.findAll();
  }

  public long countBooks() {
    return bookRepository.count();
  }

  public long countAuthors() {
    return authorRepository.count();
  }
}
