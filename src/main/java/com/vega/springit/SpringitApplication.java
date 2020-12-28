package com.vega.springit;

import com.vega.springit.domain.Comment;
import com.vega.springit.domain.Link;
import com.vega.springit.repository.CommentRepository;
import com.vega.springit.repository.LinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringitApplication.class, args);
  }

//  @Bean
  CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
    return args -> {
      Link link = new Link("Getting Started...", "danvega.com/spring");

      Comment comment = new Comment("This is awesome");
      link.addComment(comment);

      Comment comment2 = new Comment("I'm gonna enroll in it");
      link.addComment(comment2);

      linkRepository.save(link);

      List<Comment> commentList = commentRepository.findAll();

      commentList.forEach(System.out::println);

      link.removeComment(comment2);

      linkRepository.save(link);
    };
  }
}
