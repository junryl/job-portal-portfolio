package com.junrylmaraviles.job.portal.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
public class Company extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String address1;

    private String address2;

    @Column(nullable = false)
    private String websiteUrl;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String logoUrl;

    @Column(nullable = false)
    private String description;

}