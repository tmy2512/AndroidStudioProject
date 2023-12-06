package Gridview_TruyenHot;

import java.util.ArrayList;

public class HotAdapter_Helper {
    private int img;
    private String title_book;
    private String author;
    private String desc;
    private String subject;

    public HotAdapter_Helper(int img, String title_book, String author, String desc, String subject) {
        this.img = img;
        this.title_book = title_book;
        this.author = author;
        this.desc = desc;
        this.subject = subject;
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
}
