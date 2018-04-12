package com.library.controller;

import com.library.service.BookService;
import com.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    private BookService bookService;

    @Autowired
    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/hello/{name}/{lastname}", method=RequestMethod.GET)
    public String sayHello(@PathVariable String name, @PathVariable String lastname){
        return "Hello " + name +" "+ lastname;
    }

    @RequestMapping("/library/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/library/book", method = RequestMethod.POST)
    public String addABook(@RequestBody Book book){
        return bookService.addBook(book);
    }


}
