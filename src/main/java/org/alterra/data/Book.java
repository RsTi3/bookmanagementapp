package org.alterra.data;

import java.util.UUID;

public class Book {
    private String ID;
    private String judul;
    private String penulis;
    private String kategori;

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
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

    public String getPenulis() {
        return penulis;
    }

    public String getKategori() {
        return kategori;
    }
}
