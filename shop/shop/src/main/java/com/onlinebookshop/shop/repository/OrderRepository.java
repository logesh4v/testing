package com.onlinebookshop.shop.repository;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.onlinebookshop.shop.model.Order;

@Repository
public class OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for Order
    private RowMapper<Order> orderRowMapper = (rs, rowNum) ->
        new Order(rs.getInt("id"), rs.getInt("bookId"), rs.getInt("quantity"), rs.getDate("orderDate"));

    // Create -> Insert query
    public int save(Order order) {
        String sql = "INSERT INTO orders (bookId, quantity, orderDate) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, order.getBookId(), order.getQuantity(), new java.sql.Date(order.getOrderDate().getTime()));
    }

    // Read -> Get all orders
    public List<Order> findAll() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, orderRowMapper);
    }

    // Read -> Get order by ID
    public Order findById(int id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, orderRowMapper, id);
    }

    // Update order
    public int update(Order order) {
        String sql = "UPDATE orders SET bookId = ?, quantity = ?, orderDate = ? WHERE id = ?";
        return jdbcTemplate.update(sql, order.getBookId(), order.getQuantity(), new java.sql.Date(order.getOrderDate().getTime()), order.getId());
    }

    // Delete order
    public int delete(int id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
