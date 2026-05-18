package com.equb.digitalequb.dto;

public class CreateGroupRequest {
    private String groupName;
    private String description;
    private Double contributionAmount;
    private String frequency;
    private String region;
    private Integer maxMembers;
    
    // Getters and Setters
    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Double getContributionAmount() { return contributionAmount; }
    public void setContributionAmount(Double contributionAmount) { this.contributionAmount = contributionAmount; }
    
    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }
    
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
    
    public Integer getMaxMembers() { return maxMembers; }
    public void setMaxMembers(Integer maxMembers) { this.maxMembers = maxMembers; }
}