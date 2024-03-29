package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

    List<JobAdvertisement> findByStatusTrue();

    List<JobAdvertisement> findByStatusTrueOrderByApplicationStart();

    JobAdvertisement findJobAdvertisementById(int id);

}
