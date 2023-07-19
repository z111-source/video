package com.example.videodemo.book;

public class Detail {
    private String bookTitle;
    private String bookContent;

    public Detail(String bookTitle, String bookContent) {
        this.bookTitle = bookTitle;
        this.bookContent = bookContent;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookContent() {
        return bookContent;
    }

    public void setBookContent(String bookContent) {
        this.bookContent = bookContent;
    }
}
