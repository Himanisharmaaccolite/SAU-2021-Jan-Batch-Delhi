package com.example.test.controller;

import com.example.test.model.Book;
import com.example.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Book>> listAllBooks(){
        try{
            return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Integer> saveBook(@RequestBody Book book) {
        try{
            if(book == null || book.getName() == null || book.getAuthorName() == null || book.getName().isEmpty() || book.getAuthorName().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public  Book findById(@PathVariable("id") int id){
        return this.bookService.findBookId(id);
    }

    @PutMapping("/update")
    public ResponseEntity updateBook(@RequestBody Book book) {
        try{
            bookService.updateBook(book);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable("id") int id) {
        try{
            return new ResponseEntity<>(this.bookService.deleteBook(id), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
