package com.smu.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String shortDescription;
    private String longDescription;
    private String requiredExpertise;
    private String preferredExpertise;
    private double budget;
    private String location;

    // private Organization organization; // Add this entity later

}
