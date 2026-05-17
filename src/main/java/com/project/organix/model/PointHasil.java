package com.project.organix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "point_hasil")
public class PointHasil extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Boleh kosong (nullable) karena pengurangan poin/penukaran tidak selalu dari transaksi sampah
    @ManyToOne
    @JoinColumn(name = "transaksi_id")
    private Transaksi transaksi;

    @Column(name = "point_masuk", nullable = false)
    private Integer pointMasuk;

    @Column(nullable = false)
    private String keterangan;

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Transaksi getTransaksi() { return transaksi; }
    public void setTransaksi(Transaksi transaksi) { this.transaksi = transaksi; }

    public Integer getPointMasuk() { return pointMasuk; }
    public void setPointMasuk(Integer pointMasuk) { this.pointMasuk = pointMasuk; }

    public String getKeterangan() { return keterangan; }
    public void setKeterangan(String keterangan) { this.keterangan = keterangan; }
}