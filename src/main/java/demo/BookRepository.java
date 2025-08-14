package demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "books") // endpoint: /api/books
// RepositoryRestResource creates a RESTful API for the Book entity
// enables HATEOAS
public interface BookRepository extends JpaRepository<Book, Long> {

  @RestResource(path = "title-contains", rel = "title-contains")
  List<Book> findByTitleContainingIgnoreCase(@Param("title") String title);
}

// request
//curl --request GET \
//     --url 'http://localhost:8080/api/books/search/title-contains?title=Java'
//
//response:
//{
//  "_embedded": {
//    "books": [
//      {
//        "id": 1,
//        "title": "Effective Java",
//        "author": "Joshua Bloch",
//        "createdAt": "2025-08-14T12:06:51.256746Z",
//        "_links": {
//          "self": {
//            "href": "http://localhost:8080/api/books/1"
//          },
//          "book": {
//            "href": "http://localhost:8080/api/books/1{?projection}",
//            "templated": true
//          }
//        }
//      }
//    ]
//  },
//  "_links": {
//    "self": {
//      "href": "http://localhost:8080/api/books/search/title-contains?title=Java"
//    }
//  }
//}
