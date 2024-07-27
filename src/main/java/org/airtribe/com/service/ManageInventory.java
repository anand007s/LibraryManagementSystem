package org.airtribe.com.service;

import org.airtribe.com.entities.Book;

import java.util.List;

public class ManageInventory {

    public List<Book> getAvailableBooks(){
        List<Book> availableBooks = ManageBook.books.stream()
                .filter(book -> book.isAvailable()==true)
                .toList();
        return availableBooks;
    }

    public List<Book> getBorrowedBooks(){
        List<Book> borrowedBooks = ManageBook.books.stream()
                .filter(book -> book.isAvailable()==false)
                .toList();
        return borrowedBooks;
    }
}
