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
    private String organizationId; //this will connect us to Team one's entity when they are done


    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    public String getLongDescription() {
        return longDescription;
    }
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
    public String getRequiredExpertise() {
        return requiredExpertise;
    }
    public void setRequiredExpertise(String requiredExpertise) {
        this.requiredExpertise = requiredExpertise;
    }
    public String getPreferredExpertise() {
        return preferredExpertise;
    }
    public void setPreferredExpertise(String preferredExpertise) {
        this.preferredExpertise = preferredExpertise;
    }
    public double getBudget() {
        return budget;
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getOrganizationId() {
        return organizationId;
    }
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

}
