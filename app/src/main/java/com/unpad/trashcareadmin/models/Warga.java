package com.unpad.trashcareadmin.models;

public class Warga {
    private String nama;
    private String alamat;
    private String no_telp;
    private String id_warga;
    private String password;

    public Warga() {

    }

    public Warga(String nama, String alamat, String no_telp, String id_warga, String password) {
        this.nama = nama;
        this.alamat = alamat;
        this.no_telp = no_telp;
        this.id_warga = id_warga;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getId_warga() {
        return id_warga;
    }

    public void setId_warga(String id_warga) {
        this.id_warga = id_warga;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
