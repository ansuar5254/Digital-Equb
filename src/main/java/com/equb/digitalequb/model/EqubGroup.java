package com.equb.digitalequb.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "equb_groups")
public class EqubGroup {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String groupName;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private Double contributionAmount;
    
    @Column(nullable = false)
    private String frequency; // WEEKLY, MONTHLY, DAILY
    
    @Column(nullable = false)
    private String region; // Addis Ababa, Oromia, etc.
    
    @Column(nullable = false)
    private Integer totalMembers = 0;
    
    @Column(nullable = false)
    private Integer maxMembers;
    
    @Column(nullable = false)
    private String status = "ACTIVE"; // ACTIVE, CLOSED, COMPLETED
    
    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private User admin;
    
    private LocalDateTime createdAt = LocalDateTime.now();
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
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
    
    public Integer getTotalMembers() { return totalMembers; }
    public void setTotalMembers(Integer totalMembers) { this.totalMembers = totalMembers; }
    
    public Integer getMaxMembers() { return maxMembers; }
    public void setMaxMembers(Integer maxMembers) { this.maxMembers = maxMembers; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public User getAdmin() { return admin; }
    public void setAdmin(User admin) { this.admin = admin; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}