package com.smu.model;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "JOBS")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isActive;


    @Column(unique = true)
    private String title;

    private String goals;

    private float minSalary;
    private float maxSalary;


    @Enumerated(EnumType.STRING)
    private JobStatus status;

    private String description;

    private String url;

    private String organization;

    private String location;

    private String requiredExpertise;

    private String preferredExpertise;

    private Long jobPublisherId;

    private String password;

    private String email;

}
