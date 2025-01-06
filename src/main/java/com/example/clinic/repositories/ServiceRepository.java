package com.example.clinic.repositories;


import com.example.clinic.entities.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Services, Long> {
//
//    @Query("SELECT s.name, COUNT(*) as usageCount FROM Service s " +
//            "JOIN s.visits v " +
//            "GROUP BY s.name " +
//            "ORDER BY usageCount DESC")
//    List<Object[]> findMostPopularServices();

}
