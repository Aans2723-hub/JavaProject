package com.project.organix.controller;

import com.project.organix.dto.request.TransactionRequest;
import com.project.organix.model.Transaksi;
import com.project.organix.service.interfaces.WasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class WasteTransactionController {

    private final WasteService wasteService;

    @Autowired
    public WasteTransactionController(WasteService wasteService) {
        this.wasteService = wasteService;
    }

    // Endpoint untuk mencatat setoran sampah baru (POST)
    @PostMapping
    public ResponseEntity<String> addTransaction(@RequestBody TransactionRequest request) {
        String response = wasteService.recordTransaction(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Endpoint untuk melihat riwayat sampah milik satu warga (GET)
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Transaksi>> getHistoryByUser(@PathVariable Long userId) {
        return new ResponseEntity<>(wasteService.getHistory(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Long id) {
        try {
            wasteService.deleteTransaction(id);
            return new ResponseEntity<>("Transaksi berhasil dihapus", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}