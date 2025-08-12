package demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "books") // endpoint: /api/books
public interface BookRepository extends JpaRepository<Book, Long> {

  @RestResource(path = "title-contains", rel = "title-contains")
  List<Book> findByTitleContainingIgnoreCase(@Param("title") String title);
}

