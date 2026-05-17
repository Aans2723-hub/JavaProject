package com.project.organix.service.impl;

import com.project.organix.dto.request.RedeemPointRequest;
import com.project.organix.exception.ResourceNotFoundException;
import com.project.organix.model.PointHasil;
import com.project.organix.model.User;
import com.project.organix.repository.PointHasilRepository;
import com.project.organix.repository.UserRepository;
import com.project.organix.service.interfaces.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class PointServiceImpl implements PointService {

    private final UserRepository userRepository;
    private final PointHasilRepository pointHasilRepository;

    @Autowired
    public PointServiceImpl(UserRepository userRepository, PointHasilRepository pointHasilRepository) {
        this.userRepository = userRepository;
        this.pointHasilRepository = pointHasilRepository;
    }

    @Override
    @Transactional
    public String redeemPoint(RedeemPointRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User tidak ditemukan"));

        if (user.getTotalPoint() < request.getPoinDitukar()) {
            throw new RuntimeException("Poin tidak cukup untuk melakukan penukaran!");
        }

        // Kurangi poin warga
        user.setTotalPoint(user.getTotalPoint() - request.getPoinDitukar());
        userRepository.save(user);

        // Catat di riwayat PointHasil (Nilai minus untuk penukaran)
        PointHasil riwayat = new PointHasil();
        riwayat.setUser(user);
        riwayat.setPointMasuk(-request.getPoinDitukar());
        riwayat.setKeterangan("Penukaran reward: " + request.getKeteranganItem());
        pointHasilRepository.save(riwayat);

        return "Penukaran berhasil! Sisa poin Anda: " + user.getTotalPoint();
    }
}