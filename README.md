# Book Library Backend

## Framework and Technologies Used
- Framework: Spring Boot 3.3.0
- Java Version: 17
- Database: H2 Database (runtime scope)
- ORM: Spring Data JPA

## Backend Implementation Details

### AuthorController
- **Package:** `com.library.Book.Library.BE.controller`
- **Base Path:** `/api/authors`
- **Implemented Endpoints:** GET, POST, PUT, DELETE
- **Dependencies:** AuthorService for business logic handling
- **Cross-Origin Resource Sharing (CORS):** Enabled for http://localhost:4200

### BookController
- **Package:** `com.library.Book.Library.BE.controller`
- **Base Path:** `/api/books`
- **Implemented Endpoints:** GET, POST, PUT, DELETE
- **Dependencies:** BookService for business logic handling
- **Cross-Origin Resource Sharing (CORS):** Enabled for http://localhost:4200
