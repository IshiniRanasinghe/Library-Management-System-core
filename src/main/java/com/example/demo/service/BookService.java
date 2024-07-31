package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Books;
import com.example.demo.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class BookService {

    @Autowired
    private MembersRepository bookRepository;

    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    public Books addBook(Books book) {
        return bookRepository.save(book);
    }

    public Books getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found by ID: " + id));
    }

    public Books updateBook(Long id, Books updateBook) {
        Books book = getBookById(id);

        book.setTitle(updateBook.getTitle());
        book.setAuthor(updateBook.getAuthor());
        book.setIsbn(updateBook.getIsbn());
        book.setDob(updateBook.getDob());
        book.setPages(updateBook.getPages());

        return bookRepository.save(book);
    }

    public Map<String, Boolean> deleteBook(Long id) {
        Books book = getBookById(id);
        bookRepository.delete(book);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}