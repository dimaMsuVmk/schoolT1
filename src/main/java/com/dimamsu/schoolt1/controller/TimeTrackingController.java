package com.dimamsu.schoolt1.controller;

import com.dimamsu.schoolt1.dto.AllMethodNamesResult;
import com.dimamsu.schoolt1.dto.AllTimeTrackingResult;
import com.dimamsu.schoolt1.service.TimeTrackingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TimeTrackingController implements TimeTrackingApi {
    private final TimeTrackingService timeTrackingService;


    @Override
    public ResponseEntity<AllTimeTrackingResult> getAllTimeTrackingResult() {
        return ResponseEntity.ok(timeTrackingService.getInfoTimeMethods());
    }
    //???
    @Override
    public ResponseEntity<AllTimeTrackingResult> getInfoTimeMethods(final String methodName) {
        return ResponseEntity.ok(timeTrackingService.getTimeTracking(methodName));
    }

    @Override
    public ResponseEntity<AllMethodNamesResult> getAllMethods() {
        return ResponseEntity.ok(timeTrackingService.getAllMethods());
    }

}