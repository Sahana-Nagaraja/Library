package com.library.dal;

import com.library.model.Book;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.jooq.impl.DSL.table;

@Repository
public class BookRepository {

    private DefaultDSLContext dslContext;

    @Autowired
    public BookRepository(DefaultDSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<Book> getAllBooks() {
        return dslContext
                .selectFrom(table("Books"))
                .fetch()
                .into(Book.class);
    }

    public void addBook(Book book) {
        dslContext.insertInto(table("Books"))
                .values(book.getIId(),book.getTitle(),book.getAuthor()).execute();
    }
}
