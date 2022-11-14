package com.mustache.bbs.repository;

import com.mustache.bbs.domain.entity.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalRepositoryTest {
    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    @DisplayName("DB에서 값을 잘 가져오는지 확인")
    void findById() {
        Optional<Hospital> hospital = hospitalRepository.findById(1); //hospitalRepository로 id가 1인 hospital 객체를 반환
        Hospital hp = hospital.get();
        System.out.println(hp.getId());
        assertEquals(1, hp.getId());
    }

    @Test
    void findByBusinessName(){
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");
        List<Hospital> byBusinessTypeNameIn = hospitalRepository.findByBusinessTypeNameIn(inClues);
        for(Hospital hospital : byBusinessTypeNameIn){
            System.out.println(hospital.getHospitalName());
        }
    }
}