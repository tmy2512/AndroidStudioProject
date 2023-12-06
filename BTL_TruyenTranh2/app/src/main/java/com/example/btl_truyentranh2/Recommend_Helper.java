package com.example.btl_truyentranh2;

public class Recommend_Helper {
    private int img;
    private String title_book;
    private String author;
    private String desc;
    private String subject;
    private String name_pdf;

    public Recommend_Helper(int img, String title_book, String author, String desc, String subject, String name_pdf) {
        this.img = img;
        this.title_book = title_book;
        this.author = author;
        this.desc = desc;
        this.subject = subject;
        this.name_pdf = name_pdf;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle_book() {
        return title_book;
    }

    public void setTitle_book(String title_book) {
        this.title_book = title_book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName_pdf() {
        return name_pdf;
    }

    public void setName_pdf(String name_pdf) {
        this.name_pdf = name_pdf;
    }
}
