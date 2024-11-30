package com.junrylmaraviles.job.portal.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuickApplyRequest {
    private String companyName;
    private String position;
    private String salaryRange;
    private String currency;
    private String address1;
    private String address2;
    private Boolean noExperienceRequired;
    private Boolean isRemote;
    private Boolean isHybrid;
    private Boolean isOnsite;
    private String categoryId;
    private String companyId;
    private String description;
    private String jobType;
}
