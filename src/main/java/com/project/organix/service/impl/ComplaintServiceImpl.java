package com.project.organix.service.impl;

import com.project.organix.dto.request.ComplaintRequest;
import com.project.organix.exception.ResourceNotFoundException;
import com.project.organix.model.Complaint;
import com.project.organix.model.User;
import com.project.organix.repository.ComplaintRepository;
import com.project.organix.repository.UserRepository;
import com.project.organix.service.interfaces.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final UserRepository userRepository;

    @Autowired
    public ComplaintServiceImpl(ComplaintRepository complaintRepository, UserRepository userRepository) {
        this.complaintRepository = complaintRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Complaint createComplaint(ComplaintRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User tidak ditemukan"));

        Complaint complaint = new Complaint();
        complaint.setUser(user);
        complaint.setJudul(request.getJudul());
        complaint.setDeskripsi(request.getDeskripsi());
        
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }
}