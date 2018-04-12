package com.library.controller;

import com.library.controller.LibraryController;
import com.library.model.Book;
import com.library.service.BookService;
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
public class LibraryControllerTest {

    @Mock
    private BookService bookService;

    private LibraryController libraryController;

    @Before
    public void setUp() throws Exception {
        libraryController = new LibraryController(bookService);
    }

    @Test
    public void shouldReturnAllBooks(){
        Book book1 = new Book("1","abc","def");
        Book book2 = new Book("2","ghi","jkl");

        List<Book> actual = Arrays.asList(book1,book2);
        when(bookService.getAllBooks()).thenReturn(actual);

        assertEquals(2, libraryController.getAllBooks().size());
    }

    @Test
    public void shouldAddABook(){
        Book book1 = new Book("1","abc","def");
        Book book2 = new Book("2","ghi","jkl");

        List<Book> actual = Arrays.asList(book1,book2);
        when(bookService.getAllBooks()).thenReturn(actual);

        assertEquals(2, libraryController.getAllBooks().size());
    }
}