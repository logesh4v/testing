//package com.onlinebookshop.shop.repository;
//
//import java.util.List;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import com.onlinebookshop.shop.model.Author;
//
//@Repository
//public class AuthorRepository {
//	
//	private final JdbcTemplate jdbcTemplate;
//	
//	public AuthorRepository(JdbcTemplate jdbcTemplate)
//	{
//		this.jdbcTemplate=jdbcTemplate;
//	}
//	
//	//RowMapper for Author
//	
//	private RowMapper<Author> authorRowMapper =(rs,rowNum)->
//	
//	new Author (rs.getInt("id"),rs.getString("name"),rs.getString("Country"));
//	
//	
//	//Crud operations
//	//create ->insert query 
//	
//	public int save(Author author)
//	{
//		String sql="INSERT ino authors (name,country) VALUES (?,?)";
//		return jdbcTemplate.update(sql,author.getName(),author.getCountry());
//	}
//	
//	//read all authors
//	
//	public List<Author> findAll()
//	{
//		String sql ="Select * from authors";
//		return jdbcTemplate.query(sql, authorRowMapper);
//		
//		
//	
//	
//	}
//	
//	
//	//read get author by id
//	
//	
//	public Author findById(int id)
//	{
//		String sql ="Select * from authors where id=?";
//		return jdbcTemplate.queryForObject(sql,authorRowMapper, id);		
//	}
//	
//	//update author
//	public int update (Author author)
//	{
//		String sql="Update authors set name=?, country=? where id=?";
//		return jdbcTemplate.update(sql,author.getName(),author.getCountry(),author.getId());
//	}
//	//Delete author
//	public int delete(int id)
//	{
//		String sql="Delet from authors where id=?";
//		return jdbcTemplate.update(sql,id);
//	}
//}




package com.onlinebookshop.shop.repository;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.onlinebookshop.shop.model.Author;

@Repository
public class AuthorRepository {

    private final JdbcTemplate jdbcTemplate;

    public AuthorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for Author
    private RowMapper<Author> authorRowMapper = (rs, rowNum) ->
        new Author(rs.getInt("id"), rs.getString("name"), rs.getString("country"));

    // Create -> Insert query
    public int save(Author author) {
        String sql = "INSERT INTO authors (name, country) VALUES (?, ?)";
        System.out.println("Saving author: " + author);
        return jdbcTemplate.update(sql, author.getName(), author.getCountry());
    }

    // Read -> Get all authors
    public List<Author> findAll() {
        String sql = "SELECT * FROM authors";
        System.out.println("Fetching all authors");
        return jdbcTemplate.query(sql, authorRowMapper);
    }

    // Read -> Get author by ID
    public Author findById(int id) {
        String sql = "SELECT * FROM authors WHERE id = ?";
        System.out.println("Fetching author with ID: " + id);
        return jdbcTemplate.queryForObject(sql, authorRowMapper, id);
    }

    // Update author
    public int update(Author author) {
        String sql = "UPDATE authors SET name = ?, country = ? WHERE id = ?";
        System.out.println("Updating author: " + author);
        return jdbcTemplate.update(sql, author.getName(), author.getCountry(), author.getId());
    }

    // Delete author
    public int delete(int id) {
        String sql = "DELETE FROM authors WHERE id = ?";
        System.out.println("Deleting author with ID: " + id);
        return jdbcTemplate.update(sql, id);
    }
}

