package com.hsk.graphql;

import com.hsk.graphql.repository.AuthorRepository;
import com.hsk.graphql.repository.BookRepository;
import com.hsk.graphql.resolver.BookResolver;
import com.hsk.graphql.resolver.Mutation;
import com.hsk.graphql.resolver.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class GraphqlApplication {
  public static void main(String[] args) {
    SpringApplication.run(GraphqlApplication.class, args);
  }

  @Bean
  public BookResolver authorResolver(AuthorRepository authorRepository) {
    return new BookResolver(authorRepository);
  }

  @Bean
  public Query query(AuthorRepository authorRepository, BookRepository bookRepository) {
    return new Query(bookRepository, authorRepository);
  }

  @Bean
  public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
    return new Mutation(bookRepository, authorRepository);
  }
}
