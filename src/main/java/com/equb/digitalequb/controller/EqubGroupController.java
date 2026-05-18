package com.equb.digitalequb.controller;

import com.equb.digitalequb.dto.CreateGroupRequest;
import com.equb.digitalequb.model.EqubGroup;
import com.equb.digitalequb.service.EqubGroupService;
import com.equb.digitalequb.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class EqubGroupController {
    
    @Autowired
    private EqubGroupService equbGroupService;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @PostMapping("/create")
    public ResponseEntity<?> createGroup(@RequestBody CreateGroupRequest request,
                                          @RequestHeader("Authorization") String authHeader) {
        try {
            // Extract token from Bearer header
            String token = authHeader.substring(7);
            String email = jwtUtil.extractEmail(token);
            
            // Get user ID (you need to add this method to UserRepository)
            // For now, we'll get it from email - you'll need to add findByEmail method
            Long adminId = 1L; // Temporary - we'll fix this
            
            EqubGroup group = equbGroupService.createGroup(request, adminId);
            
            return ResponseEntity.ok(group);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/all")
    public ResponseEntity<?> getAllGroups() {
        try {
            List<EqubGroup> groups = equbGroupService.getAllGroups();
            return ResponseEntity.ok(groups);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getGroupById(@PathVariable Long id) {
        try {
            EqubGroup group = equbGroupService.getGroupById(id);
            return ResponseEntity.ok(group);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/region/{region}")
    public ResponseEntity<?> getGroupsByRegion(@PathVariable String region) {
        try {
            List<EqubGroup> groups = equbGroupService.getGroupsByRegion(region);
            return ResponseEntity.ok(groups);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}