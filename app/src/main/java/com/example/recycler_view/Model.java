package com.example.recycler_view;

public class Model {
    int image;
    String name, email, phone;

    public Model() {
    }

    public Model(int image, String name, String email, String phone) {
        this.image = image;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}