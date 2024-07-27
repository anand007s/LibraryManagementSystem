package org.airtribe.com.entities;

import java.util.Date;

public class Landing {
    private Book book;
    private Patron patron;
    private Date checkoutDate;
    private Date returnDate;

    public Landing(Book book, Patron patron, Date checkoutDate, Date returnDate) {
        this.book = book;
        this.patron = patron;
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Landing{" +
                "book=" + book +
                ", patron=" + patron +
                ", checkoutDate=" + checkoutDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
