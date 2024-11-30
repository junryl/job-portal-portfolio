package com.junrylmaraviles.job.portal.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostJobRequest {
    private String jobTitle;
    private String salaryRange;
    private Long categoryId;
    private String workLocation;
    private String jobType;
    private String jobDescription;
    private String currency;
    private String companyName;
    private String companyAddress1;
    private String companyAddress2;
    private String companyWebsite;
    private String companyEmail;
    private String companyDescription;
}