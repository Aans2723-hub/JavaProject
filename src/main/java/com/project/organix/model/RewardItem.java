package com.project.organix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reward_item")
public class RewardItem extends BaseEntity {

    @Column(name = "nama_item", nullable = false)
    private String namaItem;

    @Column(name = "poin_dibutuhkan", nullable = false)
    private Integer poinDibutuhkan;

    private String deskripsi;

    @Column(nullable = false)
    private Integer stok = 0;

    // --- Getter dan Setter ---
    public String getNamaItem() { return namaItem; }
    public void setNamaItem(String namaItem) { this.namaItem = namaItem; }

    public Integer getPoinDibutuhkan() { return poinDibutuhkan; }
    public void setPoinDibutuhkan(Integer poinDibutuhkan) { this.poinDibutuhkan = poinDibutuhkan; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public Integer getStok() { return stok; }
    public void setStok(Integer stok) { this.stok = stok; }
}