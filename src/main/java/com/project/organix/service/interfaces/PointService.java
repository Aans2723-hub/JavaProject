package com.project.organix.service.interfaces;

import com.project.organix.dto.request.RedeemPointRequest;

public interface PointService {
    String redeemPoint(RedeemPointRequest request);
}