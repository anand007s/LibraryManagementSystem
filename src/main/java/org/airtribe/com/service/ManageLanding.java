package org.airtribe.com.service;

import org.airtribe.com.entities.Book;
import org.airtribe.com.entities.Landing;
import org.airtribe.com.entities.Patron;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ManageLanding {

    static List<Landing> landings;

    public ManageLanding(){
        landings = new ArrayList<>();
    }

    public void checkoutBook(Book book, Patron patron, Date checkoutDate, Date returnData){
        Landing landing = new Landing(book, patron, checkoutDate, returnData);
        List<Book> newBorrowingHistory = new ArrayList<>();
        newBorrowingHistory.add(book);
        patron.setBorrowingHistory(newBorrowingHistory);
        book.setAvailable(false);
        landings.add(landing);
    }

    public void returnBook(Book book){
        Optional<Landing> returnedBook = landings.stream()
                .filter(book1 -> book1.getBook().getTitle().equals(book.getTitle()))
                .findFirst();
        if(returnedBook.isPresent()){
            returnedBook.get().getBook().setAvailable(true);
            landings.remove(returnedBook);
        }
    }
}
