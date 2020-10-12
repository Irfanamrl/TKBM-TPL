package id.ac.ui.cs.mobileprogramming.muhammadirfanamrullah.lab;

public class Manga {
    private String title;
    private String author;
    private String details;

    public Manga(String title, String author, String details) {
        this.title = title;
        this.author = author;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDetails() {
        return details;
    }
}