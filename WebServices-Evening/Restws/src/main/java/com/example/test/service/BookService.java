package com.example.test.service;

import com.example.test.dao.BookDao;
import com.example.test.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public int saveBook(Book book) {
        return bookDao.saveBook(book);
    }

    public Book findBookId(int id) {
        return bookDao.findBookById(id);
    }

    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    public boolean deleteBook(int id) {
        return bookDao.deleteBookById(id);
    }

}
