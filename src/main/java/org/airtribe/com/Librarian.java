package org.airtribe.com;

import org.airtribe.com.entities.Book;
import org.airtribe.com.entities.Patron;
import org.airtribe.com.service.ManageBook;
import org.airtribe.com.service.ManageInventory;
import org.airtribe.com.service.ManageLanding;
import org.airtribe.com.service.ManagePatron;

import java.util.Date;

public class Librarian {
    public static void main(String[] args) {
        // Create some sample books
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", 1234567890L, new Date(1960, 7, 11), true);
        Book book2 = new Book("1984", "George Orwell", 2345678901L, new Date(1949, 6, 8), true);
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 3456789012L, new Date(1925, 4, 10), true);

        // Create some sample patrons
        Patron patron1 = new Patron("John Doe", 1234567890L, "johndoe@example.com");
        Patron patron2 = new Patron("Jane wick", 2345678901L, "janewick@example.com");

        // Create a ManageBook instance
        ManageBook manageBook = new ManageBook();
        manageBook.addBook(book1);
        manageBook.addBook(book2);
        manageBook.addBook(book3);

        // Create a ManagePatron instance
        ManagePatron managePatron = new ManagePatron();
        managePatron.addPatron(patron1);
        managePatron.addPatron(patron2);

        // Create a ManageLanding instance
        ManageLanding manageLanding = new ManageLanding();

        // Checkout a book
        manageLanding.checkoutBook(book1, patron1, new Date(), new Date(System.currentTimeMillis() + 604800000)); // 1 week from now

        // Print out the borrowing history
        System.out.println("Borrowing History:");
        for (Book book : patron1.getBorrowingHistory()) {
            System.out.println(book.getTitle());
        }

        // Return a book
        manageLanding.returnBook(book1);

        // Print out the available books
        System.out.println("Available Books:");
        ManageInventory manageInventory = new ManageInventory();
        manageInventory.getAvailableBooks().forEach(System.out::println);
    }
}