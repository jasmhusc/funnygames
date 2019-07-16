package library;

import java.util.Date;

public class Book {
    private String bookname;
    private String author;
    private Date date;

    public Book() {
    }

    public Book(String bookname, String author, Date date) {
        this.bookname = bookname;
        this.author = author;
        this.date = date;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
