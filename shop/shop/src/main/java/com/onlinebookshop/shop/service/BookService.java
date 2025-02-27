package com.onlinebookshop.shop.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.onlinebookshop.shop.model.Book;
import com.onlinebookshop.shop.repository.BookRepository;
 
//@Service
//public class BookService {
//    private BookRepository bookRepository;
//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//    public void addBook(Book book) {
//        bookRepository.save(book);
//    }
//    public List<Book> getAllBooks() {
//        return bookRepository.findAll();
//    }
//    public Book getBookById(int id) {
//        return bookRepository.findById(id);
//    }
//    public void updateBook(Book book) {
//        bookRepository.update(book);
//    }
//    public void deleteById(int id) {
//        bookRepository.delete(id);
//    }
//}


@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        System.out.println("Adding book: " + book);
        bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        System.out.println("Fetching all books");
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        System.out.println("Fetching book by ID: " + id);
        return bookRepository.findById(id);
    }

    public void updateBook(Book book) {
        System.out.println("Updating book: " + book);
        bookRepository.update(book);
    }

    public void deleteById(int id) {
        System.out.println("Deleting book by ID: " + id);
        bookRepository.delete(id);
    }
}
