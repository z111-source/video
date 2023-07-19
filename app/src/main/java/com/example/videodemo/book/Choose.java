package com.example.videodemo.book;

public class Choose {
    private String bookNum;
    private String bookIntro;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Choose(String bookNum, String bookIntro) {
        this.bookNum = bookNum;
        this.bookIntro = bookIntro;
    }

    public String getBookNum() {
        return bookNum;
    }

    public void setBookNum(String bookNum) {
        this.bookNum = bookNum;
    }

    public String getBookIntro() {
        return bookIntro;
    }

    public void setBookIntro(String bookIntro) {
        this.bookIntro = bookIntro;
    }
}
