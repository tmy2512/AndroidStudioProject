package com.example.btl_truyentranh2;

import java.util.List;

public class Sach {
    private String id;
    private String img;
    private String title_book;
    private String author;
    private String desc;
    private String subject;
    private List<String> chapters;

    public Sach() {
    }

    public Sach(String id, String img, String title_book, String author, String desc, String subject, List<String> chapters) {
        this.id = id;
        this.img = img;
        this.title_book = title_book;
        this.author = author;
        this.desc = desc;
        this.subject = subject;
        this.chapters = chapters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
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

    public List<String> getChapters() {
        return chapters;
    }

    public void setChapters(List<String> chapters) {
        this.chapters = chapters;
    }
}
