package com.project.organix.dto.response;

import java.time.LocalDateTime;

public class TransactionResponse {
    private Long id;
    private Long userId;
    private String namaUser;
    private LocalDateTime tanggal;
    private Double totalBerat;
    private Integer totalPoint;
    private String status;

    // --- Constructor Kosong ---
    public TransactionResponse() {}

    // --- Constructor Lengkap ---
    public TransactionResponse(Long id, Long userId, String namaUser, LocalDateTime tanggal, Double totalBerat, Integer totalPoint, String status) {
        this.id = id;
        this.userId = userId;
        this.namaUser = namaUser;
        this.tanggal = tanggal;
        this.totalBerat = totalBerat;
        this.totalPoint = totalPoint;
        this.status = status;
    }

    // --- Getter dan Setter ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getNamaUser() { return namaUser; }
    public void setNamaUser(String namaUser) { this.namaUser = namaUser; }

    public LocalDateTime getTanggal() { return tanggal; }
    public void setTanggal(LocalDateTime tanggal) { this.tanggal = tanggal; }

    public Double getTotalBerat() { return totalBerat; }
    public void setTotalBerat(Double totalBerat) { this.totalBerat = totalBerat; }

    public Integer getTotalPoint() { return totalPoint; }
    public void setTotalPoint(Integer totalPoint) { this.totalPoint = totalPoint; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}