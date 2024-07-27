package org.airtribe.com.service;

import org.airtribe.com.entities.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ManageBook {

    public static List<Book> books;

    public ManageBook(){
        books = new ArrayList<>();
    }

    public Book addBook(Book book){
        books.add(book);
        return book;
    }

    public Book removeBook(Book book){
        books.remove(book);
        return book;
    }

    public Book updateBook(long isbn, Book book){
        Optional<Book> findBook = books.stream()
                .filter(book1 -> book1.getIsbn() == isbn)
                .findFirst();
        if(findBook.isPresent()){
            findBook = Optional.ofNullable(book);
            removeBook(findBook.get());
            books.add(book);
        }
        return book;
    }

    public Optional<Book> searchBook(String query){
        return books.stream()
                .filter(book -> matchAuthor(book, query) || matchTitle(book, query)  || matchIsbn(book, query))
                .findFirst();
    }

    private boolean matchTitle(Book book, String query){
        return book.getTitle().toLowerCase().contains(query.toLowerCase());
    }

    private boolean matchAuthor(Book book, String query){
        return book.getAuthor().toLowerCase().contains(query.toLowerCase());
    }

    private boolean matchIsbn(Book book, String query){
        return String.valueOf(book.getIsbn()).equals(query);
    }
}
