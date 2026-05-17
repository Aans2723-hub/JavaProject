package com.project.organix.service.interfaces;

import com.project.organix.dto.request.TransactionRequest;
import com.project.organix.model.Transaksi;
import java.util.List;

public interface WasteService {
    String recordTransaction(TransactionRequest request);
    List<Transaksi> getHistory(Long userId);
    void deleteTransaction(Long id);
}