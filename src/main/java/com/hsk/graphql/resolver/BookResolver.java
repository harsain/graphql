package com.hsk.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.hsk.graphql.model.Author;
import com.hsk.graphql.model.Book;
import com.hsk.graphql.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookResolver implements GraphQLResolver<Book> {
  private AuthorRepository authorRepository;

  public Author getAuthor(Book book) {
    return authorRepository.findById(book.getAuthor().getId()).orElse(null);
  }
}
