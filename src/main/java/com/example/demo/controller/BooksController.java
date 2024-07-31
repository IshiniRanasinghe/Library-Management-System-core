package com.example.demo.controller;

import com.example.demo.model.Books;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Books> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public Books addBook(@RequestBody Books book) {
        return bookService.addBook(book);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable Long id) {
        Books book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable Long id, @RequestBody Books updateBook) {
        Books updatedBook = bookService.updateBook(id, updateBook);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBook(@PathVariable Long id) {
        Map<String, Boolean> response = bookService.deleteBook(id);
        return ResponseEntity.ok(response);
    }
}