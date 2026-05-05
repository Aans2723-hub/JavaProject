package com.project.organix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "kategori_sampah")
public class KategoriSampah extends BaseEntity {

    @Column(name = "nama_kategori", nullable = false)
    private String namaKategori;

    @Column(nullable = false)
    private Double harga;

    private String deskripsi;

    // --- Syarat Encapsulation: Getter dan Setter ---
    
    public String getNamaKategori() { return namaKategori; }
    public void setNamaKategori(String namaKategori) { this.namaKategori = namaKategori; }

    public Double getHarga() { return harga; }
    public void setHarga(Double harga) { this.harga = harga; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
}