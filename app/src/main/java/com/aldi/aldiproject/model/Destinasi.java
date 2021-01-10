package com.aldi.aldiproject.model;

public class Destinasi {
    String nama;
    String daerah;
    String jenis;
    String deskripsi;

    public Destinasi(String nama, String daerah, String jenis, String deskripsi) {
        this.nama = nama;
        this.daerah = daerah;
        this.jenis = jenis;
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDaerah() {
        return daerah;
    }

    public void setDaerah(String daerah) {
        this.daerah = daerah;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
