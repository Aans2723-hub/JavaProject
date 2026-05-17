package com.project.organix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transaksi_detail")
public class TransaksiDetail extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "transaksi_id", nullable = false)
    private Transaksi transaksi;

    @ManyToOne
    @JoinColumn(name = "kategori_id", nullable = false)
    private KategoriSampah kategoriSampah;

    @Column(nullable = false)
    private Double berat;

    @Column(nullable = false)
    private Integer poin;

    // --- Getter dan Setter ---
    public Transaksi getTransaksi() { return transaksi; }
    public void setTransaksi(Transaksi transaksi) { this.transaksi = transaksi; }

    public KategoriSampah getKategoriSampah() { return kategoriSampah; }
    public void setKategoriSampah(KategoriSampah kategoriSampah) { this.kategoriSampah = kategoriSampah; }

    public Double getBerat() { return berat; }
    public void setBerat(Double berat) { this.berat = berat; }

    public Integer getPoin() { return poin; }
    public void setPoin(Integer poin) { this.poin = poin; }
}