package com.project.organix.service.impl;

import com.project.organix.model.PointHasil;
import com.project.organix.model.Transaksi;
import com.project.organix.model.User;
import com.project.organix.repository.PointHasilRepository;
import com.project.organix.repository.TransaksiRepository;
import com.project.organix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class InactivitySchedulerService {

    private final UserRepository userRepository;
    private final TransaksiRepository transaksiRepository;
    private final PointHasilRepository pointHasilRepository;

    @Autowired
    public InactivitySchedulerService(UserRepository userRepository, TransaksiRepository transaksiRepository, PointHasilRepository pointHasilRepository) {
        this.userRepository = userRepository;
        this.transaksiRepository = transaksiRepository;
        this.pointHasilRepository = pointHasilRepository;
    }

    // Cron berjalan setiap hari pada jam 00:00 (tengah malam)
    @Scheduled(cron = "0 0 0 * * ?")
    public void deductPointsForInactivity() {
        List<User> users = userRepository.findAll();
        LocalDateTime now = LocalDateTime.now();

        for (User user : users) {
            List<Transaksi> userTransactions = transaksiRepository.findByUserId(user.getId());
            
            if (!userTransactions.isEmpty()) {
                // Ambil transaksi terakhir (mengasumsikan list berurutan berdasarkan ID)
                Transaksi lastTx = userTransactions.get(userTransactions.size() - 1);
                long daysInactive = ChronoUnit.DAYS.between(lastTx.getTanggal(), now);

                // Jika lebih dari 30 hari dan poinnya masih lebih dari 0
                if (daysInactive >= 30 && user.getTotalPoint() > 0) {
                    int penalty = 50; // Pengurangan 50 poin
                    
                    user.setTotalPoint(Math.max(0, user.getTotalPoint() - penalty));
                    userRepository.save(user);

                    // Catat riwayat pengurangan poin di PointHasil
                    PointHasil logPoint = new PointHasil();
                    logPoint.setUser(user);
                    logPoint.setPointMasuk(-penalty); // Nilai minus
                    logPoint.setKeterangan("Penalti poin karena tidak aktif selama 30 hari");
                    pointHasilRepository.save(logPoint);
                }
            }
        }
    }
}