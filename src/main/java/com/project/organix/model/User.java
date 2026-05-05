package com.project.organix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED) // Menyiapkan inheritance untuk class Citizen/Admin nantinya
public class User extends BaseEntity {

    @Column(nullable = false)
    private String nama;

    private String alamat;

    @Column(name = "no_hp")
    private String noHp;

    @Column(nullable = false)
    private String password;

    @Column(name = "total_point")
    private Integer totalPoint = 0; // Default nilai poin 0

    // --- Syarat Encapsulation: Getter dan Setter ---
    // (Jika Anda memakai dependensi Lombok, kode ini bisa diganti cukup dengan anotasi @Data di atas class)
    
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    public String getNoHp() { return noHp; }
    public void setNoHp(String noHp) { this.noHp = noHp; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Integer getTotalPoint() { return totalPoint; }
    public void setTotalPoint(Integer totalPoint) { this.totalPoint = totalPoint; }
}