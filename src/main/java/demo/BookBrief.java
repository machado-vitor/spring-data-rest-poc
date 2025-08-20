package demo;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "brief", types = Book.class)
public interface BookBrief {
  String getTitle();
  String getAuthor();
}

// projections are a way to customize the JSON representation
// of the entities returned by Spring Data REST without changing the underlying domain model.

// This let us control which properties are included in reponses.
// This is helpful to:
// - Limit payload size
// - Hide sensitive or verbose fields.
// - provide different views of the same resource for different use cases.



// Types of projections
// - closed (interface-based) THIS EXAMPLE.
//    - needs to declare a java interface with getter methods for the properties we want to expose
//    - annotate with @Projection, specifying a name and the target entity type(s).
//    - Only the properties defined by the interface are serialized.
// - open
//    - Also interface-based, but you can define computed values using SpEL with @value.
//    - useful for concatenating fields, formatting or pulling nested properties.

// An alternative concept is Jackson @JsonView.

// HOW TO USE it
// GET /books?projection=brief
// GET /books/{id}?projection=brief
// reponse:

//{
//  "_embedded": {
//    "books": [
//      {
//        "_links": {
//          "self": {
//            "href": "http://localhost:8080/api/books/1"
//          },
//          "book": {
//            "href": "http://localhost:8080/api/books/1{?projection}",
//            "templated": true
//          }
//        },
//        "author": "Joshua Bloch",
//        "title": "Effective Java"
//      },
//      {
//        "_links": {
//          "self": {
//            "href": "http://localhost:8080/api/books/2"
//          },
//          "book": {
//            "href": "http://localhost:8080/api/books/2{?projection}",
//            "templated": true
//          }
//        },
//        "author": "Craig Walls",
//        "title": "Spring in Action"
//      },
//      {
//        "_links": {
//          "self": {
//            "href": "http://localhost:8080/api/books/3"
//          },
//          "book": {
//            "href": "http://localhost:8080/api/books/3{?projection}",
//            "templated": true
//          }
//        },
//        "author": "Robert C. Martin",
//        "title": "Clean Code"
//      }
//    ]
//  },
//  "_links": {
//    "self": {
//      "href": "http://localhost:8080/api/books?projection=brief&page=0&size=20"
//    },
//    "profile": {
//      "href": "http://localhost:8080/api/profile/books"
//    },
//    "search": {
//      "href": "http://localhost:8080/api/books/search"
//    }
//  },
//  "page": {
//    "size": 20,
//    "totalElements": 3,
//    "totalPages": 1,
//    "number": 0
//  }
//}
