package com.example.buoi9;

public class Product {
    int id;
    String title;
    int publisher_id;

    public Product(int id, String title, int publisher_id) {
        this.id = id;
        this.title = title;
        this.publisher_id = publisher_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }
}
