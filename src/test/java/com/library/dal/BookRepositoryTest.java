package com.library.dal;

import com.library.model.Book;
import org.jooq.impl.DefaultDSLContext;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private DefaultDSLContext dslContext;

    @Test
    public void shouldReturnAllBooks() {
        List<Book> allBooks = bookRepository.getAllBooks();
        assertEquals(5, allBooks.size());
    }

    @Transactional
    @Test
    public void shouldAddABook() {
        Book book = new Book("1","abcc","def");
        bookRepository.addBook(book);
        assertEquals(6, bookRepository.getAllBooks().size());
    }

//    @After
//    public void tearDown() throws Exception {
//        dslContext.delete(table("Books")).where(field("id").eq("1")).execute();
//    }
}