package com.junrylmaraviles.job.portal.service;

import com.junrylmaraviles.job.portal.dto.request.PostJobRequest;
import com.junrylmaraviles.job.portal.dto.request.QuickApplyRequest;
import com.junrylmaraviles.job.portal.entity.Currency;
import com.junrylmaraviles.job.portal.entity.Job;
import com.junrylmaraviles.job.portal.entity.Company;
import com.junrylmaraviles.job.portal.repository.CompanyRepository;
import com.junrylmaraviles.job.portal.repository.JobRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public JobService(JobRepository jobRepository, CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
    }

    public String saveImage(MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return filePath.toString();
    }

    public Resource getImage(String filename) throws MalformedURLException {
        Path filePath = Paths.get(uploadDir).resolve(filename);
        return new UrlResource(filePath.toUri());
    }

    public Job quickApply(QuickApplyRequest data) {
        var job = Job.builder()
                .companyName(data.getCompanyName())
                .position(data.getPosition())
                .categoryId(data.getCategoryId())
                .companyId(data.getCompanyId())
                .description(data.getDescription())
                .jobType(data.getJobType())
                .salaryRange(data.getSalaryRange())
                .build();
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Transactional
    public void postJob(PostJobRequest postJobRequest) {

        try {
            //todo: create a new company if not exists
            var company = Company.builder()
                    .companyName(postJobRequest.getCompanyName())
                    .address1(postJobRequest.getCompanyAddress1())
                    .address2(postJobRequest.getCompanyAddress2())
                    .websiteUrl(postJobRequest.getCompanyWebsite())
                    .email(postJobRequest.getCompanyEmail())
                    .logoUrl("") //todo
                    .description(postJobRequest.getCompanyDescription())
                    .build();
            Company companyResult = companyRepository.save(company);

            if (companyResult.getId() != null) {
                var job = Job.builder()
                        .companyName(postJobRequest.getCompanyName())
                        .position(postJobRequest.getJobTitle())
                        .salaryRange(postJobRequest.getSalaryRange())
                        .currency(postJobRequest.getCurrency() != null ? postJobRequest.getCurrency() : Currency.PHP.name())
                        .noExperienceRequired(false) //todo
                        .isRemote(Objects.equals(postJobRequest.getWorkLocation(), "home"))
                        .isHybrid(Objects.equals(postJobRequest.getWorkLocation(), "hybrid"))
                        .isOnsite(Objects.equals(postJobRequest.getWorkLocation(), "onsite"))
                        .categoryId(String.valueOf(postJobRequest.getCategoryId().longValue()))
                        .companyId(companyResult.getId().toString())
                        .description(postJobRequest.getJobDescription())
                        .jobType(postJobRequest.getJobType())
                        .build();
                jobRepository.save(job);
            } else {
                System.out.println("Post job failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
