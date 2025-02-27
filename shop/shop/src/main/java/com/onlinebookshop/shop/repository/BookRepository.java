//package com.onlinebookshop.shop.repository;
//	
//	//cretae a new book 
//	// read--get all books
//	// read-get book by id
//	//update book -find by id
//	//delete book -int id
//
//
//import java.util.List;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import com.onlinebookshop.shop.model.Book;
//
//@Repository
//public class BookRepository {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public BookRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    // RowMapper for Book
//    private RowMapper<Book> bookRowMapper = (rs, rowNum) -> 
//        new Book(rs.getInt("id"), rs.getString("title"), rs.getDouble("price"), rs.getInt("authorId"));
//
//    // Create -> Insert query
//    public int save(Book book) {
//        String sql = "INSERT INTO books (title, price, authorId) VALUES (?, ?, ?)";
//        return jdbcTemplate.update(sql, book.getTitle(), book.getPrice(), book.getAuthorId());
//    }
//
//    // Read -> Get all books
//    public List<Book> findAll() {
//        String sql = "SELECT * FROM books";
//        return jdbcTemplate.query(sql, bookRowMapper);
//    }
//
//    // Read -> Get book by ID
//    public Book findById(int id) {
//        String sql = "SELECT * FROM books WHERE id = ?";
//        return jdbcTemplate.queryForObject(sql, bookRowMapper, id);
//    }
//
//    // Update book
//    public int update(Book book) {
//        String sql = "UPDATE books SET title = ?, price = ?, authorId = ? WHERE id = ?";
//        return jdbcTemplate.update(sql, book.getTitle(), book.getPrice(), book.getAuthorId(), book.getId());
//    }
//
//    // Delete book
//    public int delete(int id) {
//        String sql = "DELETE FROM books WHERE id = ?";
//        return jdbcTemplate.update(sql, id);
//    }
//}
//



package com.onlinebookshop.shop.repository;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.onlinebookshop.shop.model.Book;

@Repository
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for Book
    private RowMapper<Book> bookRowMapper = (rs, rowNum) -> 
        new Book(rs.getInt("id"), rs.getString("title"), rs.getDouble("price"), rs.getInt("authorId"));

    // Create -> Insert query
    public int save(Book book) {
        String sql = "INSERT INTO books (title, price, authorId) VALUES (?, ?, ?)";
        System.out.println("Saving book: " + book);
        return jdbcTemplate.update(sql, book.getTitle(), book.getPrice(), book.getAuthorId());
    }

    // Read -> Get all books
    public List<Book> findAll() {
        String sql = "SELECT * FROM books";
        System.out.println("Fetching all books");
        return jdbcTemplate.query(sql, bookRowMapper);
    }

    // Read -> Get book by ID
    public Book findById(int id) {
        String sql = "SELECT * FROM books WHERE id = ?";
        System.out.println("Fetching book with ID: " + id);
        return jdbcTemplate.queryForObject(sql, bookRowMapper, id);
    }

    // Update book
    public int update(Book book) {
        String sql = "UPDATE books SET title = ?, price = ?, authorId = ? WHERE id = ?";
        System.out.println("Updating book: " + book);
        return jdbcTemplate.update(sql, book.getTitle(), book.getPrice(), book.getAuthorId(), book.getId());
    }

    // Delete book
    public int delete(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        System.out.println("Deleting book with ID: " + id);
        return jdbcTemplate.update(sql, id);
    }
}

