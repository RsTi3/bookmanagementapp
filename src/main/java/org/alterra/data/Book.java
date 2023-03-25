package org.alterra.data;

import java.util.UUID;

public class Book {
    private String ID;
    private String judul;
    private String penulis;
    private String kategori;

    public Book() {
        this.ID = UUID.randomUUID().toString();
    }

    public Book(String judul, String penulis, String kategori) {
        this.ID = UUID.randomUUID().toString();
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
    }

    public String getID() {
        return ID;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
