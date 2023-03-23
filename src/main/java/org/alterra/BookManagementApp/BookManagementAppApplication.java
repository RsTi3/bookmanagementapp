package org.alterra.BookManagementApp;

import org.alterra.data.Books;
import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class BookManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagementAppApplication.class, args);
	}

	Books books = new Books();
	@GetMapping("/books")
	public List<JSONObject> getAllBook() {
		return books.getBooks();
	}

	@PostMapping("/book")
	public JSONObject addBook(@RequestParam(value = "judul") String title, @RequestParam(value="penulis") String author, @RequestParam(value="kategori") String category) {
		return books.setBook(title, author, category);
	}

	@GetMapping("/book")
	public JSONObject getBookByID(@RequestParam(value = "id") String id) {
		return books.getBookById(id);
	}

	@PutMapping("/book")
	public JSONObject updateBookByID(@RequestParam(value = "id") String id, @RequestParam(value = "judul") String title, @RequestParam(value="penulis") String author, @RequestParam(value="kategori") String category) {
		return books.updateBook(id, title, author, category);
	}

	@DeleteMapping("/book")
	public JSONObject deleteBookByID(@RequestParam(value = "id") String id) {
		return books.deleteBook(id);
	}
}
