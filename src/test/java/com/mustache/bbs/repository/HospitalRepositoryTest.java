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
//    @Autowired
//    HospitalRepository hospitalRepository;
//
//    @Test
//    @DisplayName("병상 수가 10개 이상 20개 미만인 병원을 내림차순으로 정렬")
//    void findByPatientRoomCountOrderByDesc(){
//        List<Hospital> hospitals = hospitalRepository.findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(10,19);
//        for(Hospital hospital:hospitals){
//            System.out.println(hospital.getHospitalName() +"|"+ hospital.getPatientRoomCount());
//        }
//    }
//    @Test
//    @DisplayName("병상 수가 10개 이상 20개 미만인 병원을 모두 찾기")
//    void findByPatientRoomCount(){
//        List<Hospital> hospitals = hospitalRepository.findByPatientRoomCountBetween(10, 19);
//        for(Hospital hospital:hospitals){
//            System.out.println(hospital.getHospitalName() +"|"+ hospital.getPatientRoomCount());
//        }
//    }
//
//    @Test
//    @DisplayName("특정 구:광진구의 보건진료소, 보건지소, 보건소 모두 찾기")
//    void findByBusinessTypeNameAndDistrict(){
//        List<String> inClues = new ArrayList<>();
//        inClues.add("보건소");
//        inClues.add("보건지소");
//        inClues.add("보건진료소");
//        String district = "송파구";
//        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameInAndRoadNameAddressContaining(inClues, district);
//        for(Hospital hospital:hospitals){
//            System.out.println(hospital.getHospitalName());
//        }
//    }
//
//    @Test
//    @DisplayName("DB에서 값을 잘 가져오는지 확인")
//    void findById() {
//        Optional<Hospital> hospital = hospitalRepository.findById(1); //hospitalRepository로 id가 1인 hospital 객체를 반환
//        Hospital hp = hospital.get();
//        System.out.println(hp.getId());
//        assertEquals(1, hp.getId());
//    }
//
//    @Test
//    void findByBusinessName(){
//        List<String> inClues = new ArrayList<>();
//        inClues.add("보건소");
//        inClues.add("보건지소");
//        inClues.add("보건진료소");
//        List<Hospital> byBusinessTypeNameIn = hospitalRepository.findByBusinessTypeNameIn(inClues);
//        for(Hospital hospital : byBusinessTypeNameIn){
//            System.out.println(hospital.getHospitalName());
//        }
//    }
}