package com.project.organix.dto.request;

public class TransactionRequest {
    private Long userId;
    private Long kategoriId;
    private Double berat;

    // --- Getter dan Setter ---
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getKategoriId() { return kategoriId; }
    public void setKategoriId(Long kategoriId) { this.kategoriId = kategoriId; }

    public Double getBerat() { return berat; }
    public void setBerat(Double berat) { this.berat = berat; }
}