package com.project.organix.controller;

import com.project.organix.dto.request.RedeemPointRequest;
import com.project.organix.service.interfaces.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/points")
public class PointController {

    private final PointService pointService;

    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    // Endpoint Penukaran Poin (POST)
    @PostMapping("/redeem")
    public ResponseEntity<String> redeemPoints(@RequestBody RedeemPointRequest request) {
        try {
            String result = pointService.redeemPoint(request);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}