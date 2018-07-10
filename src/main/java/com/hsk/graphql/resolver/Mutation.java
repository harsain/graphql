package com.hsk.graphql.resolver;

import com.hsk.graphql.model.Author;
import com.hsk.graphql.model.Book;
import com.hsk.graphql.repository.AuthorRepository;
import com.hsk.graphql.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {
  private BookRepository bookRepository;
  private AuthorRepository authorRepository;

  public Author newAuthor(String firstName, String lastName){
    Author author = new Author();

    author.setFirstName(firstName);
    author.setLastName(lastName);

    authorRepository.save(author);

    return author;
  }

  public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
    Book book = new Book();
    book.setAuthor(new Author(authorId, null, null));
    book.setIsbn(isbn);
    book.setTitle(title);
    book.setPageCount(pageCount != null ? pageCount : 0);

    bookRepository.save(book);

    return book;
  }
}
