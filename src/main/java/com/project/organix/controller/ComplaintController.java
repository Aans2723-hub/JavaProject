package com.project.organix.controller;

import com.project.organix.dto.request.ComplaintRequest;
import com.project.organix.model.Complaint;
import com.project.organix.service.interfaces.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    @Autowired
    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    // Warga mengirimkan pengaduan (POST)
    @PostMapping
    public ResponseEntity<Complaint> submitComplaint(@RequestBody ComplaintRequest request) {
        return new ResponseEntity<>(complaintService.createComplaint(request), HttpStatus.CREATED);
    }

    // Admin melihat daftar pengaduan (GET)
    @GetMapping
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        return new ResponseEntity<>(complaintService.getAllComplaints(), HttpStatus.OK);
    }
}