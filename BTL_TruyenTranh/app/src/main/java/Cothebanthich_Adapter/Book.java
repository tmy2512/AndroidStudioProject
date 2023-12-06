package Cothebanthich_Adapter;

public class Book {
    private int img;
    private String title_book;

    public Book(int img, String title_book) {
        this.img = img;
        this.title_book = title_book;
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
