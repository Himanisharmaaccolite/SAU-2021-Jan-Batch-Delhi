package com.example.test.rowmapper;

import com.example.test.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt("id"));
        book.setName(resultSet.getString("name"));
        book.setAuthorName(resultSet.getString("author_name"));
        return book;
    }
}
