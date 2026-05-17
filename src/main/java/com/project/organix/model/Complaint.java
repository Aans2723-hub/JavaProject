package com.project.organix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "complaint")
public class Complaint extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String judul;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String deskripsi;

    @Column(nullable = false)
    private String status = "MENUNGGU"; // MENUNGGU, DIPROSES, SELESAI

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}