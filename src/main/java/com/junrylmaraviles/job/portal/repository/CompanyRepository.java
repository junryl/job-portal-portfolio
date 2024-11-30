package com.junrylmaraviles.job.portal.repository;

import com.junrylmaraviles.job.portal.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@EnableJpaRepositories
public interface CompanyRepository extends JpaRepository<Company, UUID> {

}