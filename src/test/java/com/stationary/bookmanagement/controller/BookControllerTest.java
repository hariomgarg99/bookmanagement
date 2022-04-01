package com.stationary.bookmanagement.controller;


import com.stationary.bookmanagement.BookManagementApplication;
import com.stationary.bookmanagement.entity.Book;
import com.stationary.bookmanagement.repository.BooksRepository;
import com.stationary.bookmanagement.service.BookService;
import com.stationary.bookmanagement.util.BookTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;

import java.math.BigDecimal;
import java.util.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BookManagementApplication.class)
public class BookControllerTest {

    @InjectMocks
    BooksController booksController;

    @Mock
    BookService bookService;

    @Mock
    BooksRepository booksRepository;


    long id = 1L;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void saveBookTest() {
        Mockito.when(bookService.saveBooks(BookTest.getBook())).thenReturn(Mockito.anyLong());
        ResponseEntity<String> response = booksController.saveBooks(BookTest.getBook());
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void getBookListTest() {
        List<Book> bookDtoList = Arrays.asList(new Book());
        Mockito.when(bookService.getBooks()).thenReturn(bookDtoList);
        ResponseEntity<List<Book>> response = booksController.getBookList();
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void updateBookTest() {
        bookService.update(id,BookTest.getBook());
        ResponseEntity response = booksController.update(id,BookTest.getBook());
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void deleteBookTest() {
        bookService.delete(id);
        ResponseEntity response = booksController.delete(id);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void totalPriceTestWithPromotionCode() {
        List<Long> bookIdsList = Arrays.asList(1L,2L,4L);
        Mockito.when(bookService.getTotalPrice(bookIdsList,"ABC")).thenReturn(BigDecimal.ONE.doubleValue());
        ResponseEntity response = booksController.getTotalPrice(bookIdsList,"ABC");
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void totalPriceTestWithoutPromotionCode() {
        List<Long> bookIdsList = Arrays.asList(1L,2L,4L);
        Mockito.when(bookService.getTotalPrice(bookIdsList,"")).thenReturn(BigDecimal.TEN.doubleValue());
        ResponseEntity response = booksController.getTotalPrice(bookIdsList,"ABC");
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }
}
