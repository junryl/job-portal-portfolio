package com.junrylmaraviles.job.portal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class Auditable {
    @CreatedBy
    protected String createdBy;

    @CreationTimestamp
    protected LocalDateTime createdDate;

    @LastModifiedBy
    protected String lastModifiedBy;

    @UpdateTimestamp
    protected LocalDateTime lastModifiedDate;

}