package demo;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "brief", types = Book.class)
public interface BookBrief {
  String getTitle();
  String getAuthor();
}

