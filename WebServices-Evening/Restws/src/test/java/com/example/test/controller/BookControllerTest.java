package com.example.test.controller;

import com.example.test.model.Book;
import com.example.test.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureMockMvc
@WebMvcTest(BookController.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookService bookService;

    @Test
    public void getAllBook() throws Exception {
        when(bookService.findBookId(1)).thenReturn(new Book().setId(1).setName("Cartoon").setAuthorName("Network"));
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/books/all"))
                .andExpect(status().isOk())
                .andReturn();
        assertNotNull(result.getResponse().getContentAsString());
    }
}
