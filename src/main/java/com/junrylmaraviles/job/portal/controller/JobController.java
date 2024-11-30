package com.junrylmaraviles.job.portal.controller;

import com.junrylmaraviles.job.portal.dto.request.QuickApplyRequest;
import com.junrylmaraviles.job.portal.entity.Job;
import com.junrylmaraviles.job.portal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/job")
public class JobController {

    @Autowired
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/quickApply")
    public ResponseEntity<Job> quickApply(@RequestBody QuickApplyRequest data) {
        try {
            Job res = jobService.quickApply(data);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
