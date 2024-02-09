package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "city")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class City {

    @Id
    @Column(name = "city_id")
    private int id;
    @Column(name = "city_name")
    private String cityName;

    @OneToMany(mappedBy = "city")
    private List<JobAdvertisement> jobAdvertisements;
}