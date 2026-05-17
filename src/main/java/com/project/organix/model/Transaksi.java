package com.project.organix.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaksi")
public class Transaksi extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "tanggal")
    private LocalDateTime tanggal = LocalDateTime.now();

    @Column(name = "total_berat")
    private Double totalBerat = 0.0;

    @Column(name = "total_point")
    private Integer totalPoint = 0;

    @Column(name = "status")
    private String status = "SELESAI";

    // --- Getter dan Setter ---
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public LocalDateTime getTanggal() { return tanggal; }
    public void setTanggal(LocalDateTime tanggal) { this.tanggal = tanggal; }

    public Double getTotalBerat() { return totalBerat; }
    public void setTotalBerat(Double totalBerat) { this.totalBerat = totalBerat; }

    public Integer getTotalPoint() { return totalPoint; }
    public void setTotalPoint(Integer totalPoint) { this.totalPoint = totalPoint; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}