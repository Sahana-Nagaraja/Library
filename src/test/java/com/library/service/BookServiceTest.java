package com.library.service;

import com.library.dal.BookRepository;
import com.library.service.BookService;
import com.library.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    private BookService bookService;

    @Before
    public void setUp() throws Exception {
        bookService = new BookService(bookRepository);
    }

    @Test
    public void shouldReturnAllBooks() {
        Book book1 = new Book("1","abc","def");
        Book book2 = new Book("2","ghi","jkl");

        List<Book> actual = Arrays.asList(book1,book2);
        when(bookRepository.getAllBooks()).thenReturn(actual);

        assertEquals(2, bookService.getAllBooks().size());
    }

//    @Test - not possible
//    public void shouldAddABook() {
//        Book book1 = new Book("1","abc","def");
//        Book book2 = new Book("2","ghi","jkl");
//        Book book = new Book("1","abc","def");
//
//        List<Book> actual = Arrays.asList(book1,book2);
//        when(bookRepository.getAllBooks()).thenReturn(actual);
//
//        bookService.addBook(book);
//        assertEquals(2, bookService.getAllBooks().size());
//    }

}