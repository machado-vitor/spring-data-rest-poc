package demo;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@RepositoryRestResource(path = "books") // endpoint: /api/books
// RepositoryRestResource creates a RESTful API for the Book entity
// enables HATEOAS
public interface BookRepository extends CrudRepository<Book, Long> {
// For this repo, the SDR exposes a collection resource at /books
// The path is derived from the uncapitalized, pluralized, simple class name of the domain class.
// It also exposes an item resource for each of the items managed by the repository.
// By default, the http methods interact with these resources map to the according methods of CrudRepository

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
