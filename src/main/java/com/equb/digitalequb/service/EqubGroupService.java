package com.equb.digitalequb.service;
import java.util.List;
import com.equb.digitalequb.dto.CreateGroupRequest;
import com.equb.digitalequb.model.EqubGroup;
import com.equb.digitalequb.model.User;
import com.equb.digitalequb.repository.EqubGroupRepository;
import com.equb.digitalequb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EqubGroupService {
    
    @Autowired
    private EqubGroupRepository equbGroupRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public EqubGroup createGroup(CreateGroupRequest request, Long adminId) {
        // Find admin user
        User admin = userRepository.findById(adminId)
            .orElseThrow(() -> new RuntimeException("Admin not found!"));
        
        // Check if group name already exists
        if (equbGroupRepository.existsByGroupName(request.getGroupName())) {
            throw new RuntimeException("Group name already exists!");
        }
        
        // Create new group
        EqubGroup group = new EqubGroup();
        group.setGroupName(request.getGroupName());
        group.setDescription(request.getDescription());
        group.setContributionAmount(request.getContributionAmount());
        group.setFrequency(request.getFrequency());
        group.setRegion(request.getRegion());
        group.setMaxMembers(request.getMaxMembers());
        group.setAdmin(admin);
        group.setTotalMembers(1); // Admin is the first member
        group.setStatus("ACTIVE");
        
        return equbGroupRepository.save(group);
    }
    
    public List<EqubGroup> getAllGroups() {
        return equbGroupRepository.findAll();
    }
    
    public EqubGroup getGroupById(Long id) {
        return equbGroupRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Group not found!"));
    }
    
    public List<EqubGroup> getGroupsByRegion(String region) {
        return equbGroupRepository.findByRegion(region);
    }
}