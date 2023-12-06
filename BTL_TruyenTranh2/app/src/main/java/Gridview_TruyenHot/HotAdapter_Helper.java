package Gridview_TruyenHot;

import java.util.ArrayList;

public class HotAdapter_Helper {
    private String img;
    private String title_book;
    private String author;
    private String desc;
    private String subject;
    private String name_pdf;

    public HotAdapter_Helper(String img, String title_book, String author, String desc, String subject, String name_pdf) {
        this.img = img;
        this.title_book = title_book;
        this.author = author;
        this.desc = desc;
        this.subject = subject;
        this.name_pdf = name_pdf;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getName_pdf() {
        return name_pdf;
    }


}
