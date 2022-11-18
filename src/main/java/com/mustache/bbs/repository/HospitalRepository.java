package com.mustache.bbs.repository;

import com.mustache.bbs.domain.entity.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypeNames);

    List<Hospital> findByBusinessTypeNameInAndRoadNameAddressContaining(List<String> businessTypeNames, String district);

    List<Hospital> findByPatientRoomCountBetween(int start, int end);

    List<Hospital> findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(int start, int end);

    Page<Hospital> findByRoadNameAddressContaining(String keyword, Pageable pageable);
}
