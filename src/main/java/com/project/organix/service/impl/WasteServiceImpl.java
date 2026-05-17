package com.project.organix.service.impl;

import com.project.organix.dto.request.TransactionRequest;
import com.project.organix.model.KategoriSampah;
import com.project.organix.model.Transaksi;
import com.project.organix.model.User;
import com.project.organix.repository.KategoriSampahRepository; // Pastikan Anda sudah membuat repository ini
import com.project.organix.repository.TransaksiRepository;
import com.project.organix.repository.UserRepository;
import com.project.organix.service.interfaces.WasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class WasteServiceImpl implements WasteService {

    private final TransaksiRepository transaksiRepository;
    private final UserRepository userRepository;
    private final KategoriSampahRepository kategoriSampahRepository;

    @Autowired
    public WasteServiceImpl(TransaksiRepository transaksiRepository, UserRepository userRepository, KategoriSampahRepository kategoriSampahRepository) {
        this.transaksiRepository = transaksiRepository;
        this.userRepository = userRepository;
        this.kategoriSampahRepository = kategoriSampahRepository;
    }

    @Override
    @Transactional
    public String recordTransaction(TransactionRequest request) {
        // 1. Cari data User dan Kategori di database
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User tidak ditemukan"));
        
        KategoriSampah kategori = kategoriSampahRepository.findById(request.getKategoriId())
                .orElseThrow(() -> new RuntimeException("Kategori tidak ditemukan"));

        // 2. Hitung total poin (Berat * Harga perkilo)
        int poinDidapat = (int) (request.getBerat() * kategori.getHarga());

        // 3. Buat dan simpan Transaksi Utama
        Transaksi transaksi = new Transaksi();
        transaksi.setUser(user);
        transaksi.setTotalBerat(request.getBerat());
        transaksi.setTotalPoint(poinDidapat);
        transaksi = transaksiRepository.save(transaksi);

        // 4. Update total poin User
        user.setTotalPoint(user.getTotalPoint() + poinDidapat);
        userRepository.save(user);

        return "Transaksi berhasil dicatat. Poin didapat: " + poinDidapat;
    }

    @Override
    public List<Transaksi> getHistory(Long userId) {
        return transaksiRepository.findByUserId(userId);
    }

    @Override
    public void deleteTransaction(Long id) {
        if (!transaksiRepository.existsById(id)) {
            throw new RuntimeException("Transaksi dengan ID tersebut tidak ditemukan");
        }
        transaksiRepository.deleteById(id);
    }
}