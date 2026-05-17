package com.project.organix.service.interfaces;

import com.project.organix.dto.request.ComplaintRequest;
import com.project.organix.model.Complaint;
import java.util.List;

public interface ComplaintService {
    Complaint createComplaint(ComplaintRequest request);
    List<Complaint> getAllComplaints();
}