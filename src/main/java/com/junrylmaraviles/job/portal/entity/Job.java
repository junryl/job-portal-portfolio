package com.junrylmaraviles.job.portal.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job")
public class Job extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String position;

    private String salaryRange;

    private String currency;

    @Column(columnDefinition="tinyint(1) default 0")
    private Boolean noExperienceRequired ;

    @Column(columnDefinition="tinyint(1) default 0")
    private Boolean isRemote;

    @Column(columnDefinition="tinyint(1) default 0")
    private Boolean isHybrid;

    @Column(columnDefinition="tinyint(1) default 0")
    private Boolean isOnsite;

    @Column(nullable = false)
    private String categoryId;

    @Column(nullable = false)
    private String companyId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String jobType;

}