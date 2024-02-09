package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
}
