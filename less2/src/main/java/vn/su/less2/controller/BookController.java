package vn.su.less2.controller;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import vn.su.less2.model.Book;
import vn.su.less2.model.BookRequest;

@RestController
@RequestMapping("/book")
public class BookController {
    private ConcurrentHashMap<String, Book> books;

    public BookController() {
        books = new ConcurrentHashMap<>();
        books.put("OX-13", new Book("OX-13", "Gone with the wind", "Cuong", 1945));
        books.put("OX-14", new Book("OX-14", "Chi Dau", "Nam Cao", 1943));
    }
    @GetMapping
    public List<Book> getBooks() {

        return books.values().stream().toList();
    }

    @GetMapping(value = "/{id}")
    public Book getBookById(@PathVariable("id") String id) {
        Book book = books.get(id);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found data");
        }
        return book;
    }
    @PostMapping
    public ResponseEntity<Book> createNewBook(@RequestBody BookRequest bookRequest) {
        String uuid = UUID.randomUUID().toString();
        Book newBook = new Book(uuid, bookRequest.title(), bookRequest.author(), bookRequest.year());
        books.put(uuid, newBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook) ;
    }
    
    @PutMapping(value = "/{id}")
    public Book updateBookById(@PathVariable("id") String id, @RequestBody BookRequest bookRequest) {
        Book updateBook = new Book(id, bookRequest.title(), bookRequest.author(), bookRequest.year());
        // books.put(id, updateBook);
        books.replace(id, updateBook);
        return updateBook;
    }
    
    @DeleteMapping(value = "/{id}")
    public Book deleteBookById(@PathVariable("id") String id) {
        Book removedBook = books.remove(id);
        return removedBook;
    }
}
