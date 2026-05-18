package com.equb.digitalequb.repository;

import com.equb.digitalequb.model.EqubGroup;
import com.equb.digitalequb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EqubGroupRepository extends JpaRepository<EqubGroup, Long> {
    List<EqubGroup> findByAdmin(User admin);
    List<EqubGroup> findByRegion(String region);
    List<EqubGroup> findByStatus(String status);
    boolean existsByGroupName(String groupName);
}