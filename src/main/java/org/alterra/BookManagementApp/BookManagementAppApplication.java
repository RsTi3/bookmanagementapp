package org.alterra.BookManagementApp;

import org.alterra.data.Book;
import org.alterra.data.Books;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@ComponentScan("org.alterra")
public class BookManagementAppApplication {

    @Autowired
    private Books books;

    public static void main(String[] args) {
        SpringApplication.run(BookManagementAppApplication.class, args);
    }

    @GetMapping("/books")
    public List<JSONObject> getAllBook() {
        return books.getBooks();
    }

    @PostMapping(path = "/book", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JSONObject> addBook(@RequestBody Book book) {
        JSONObject response = books.setBook(book.getJudul(), book.getPenulis(), book.getKategori());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/book")
    public JSONObject getBookByID(@RequestParam(value = "id") String id) {
        return books.getBookById(id);
    }

    @PutMapping(path = "/book/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JSONObject> updateBook(@PathVariable("id") String id, @RequestBody Book book) {
        JSONObject response = books.updateBook(id, book.getJudul(), book.getPenulis(), book.getKategori());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/book")
    public JSONObject deleteBookByID(@RequestParam(value = "id") String id) {
        return books.deleteBook(id);
    }
}
