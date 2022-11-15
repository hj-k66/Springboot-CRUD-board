package com.mustache.bbs.service;

import com.mustache.bbs.domain.dto.HospitalResponse;
import com.mustache.bbs.domain.entity.Hospital;
import com.mustache.bbs.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

   public HospitalResponse getHospital(Integer id){
       Optional<Hospital> opthospital = hospitalRepository.findById(id);
       Hospital hospital = opthospital.get();
       HospitalResponse hospitalResponse = Hospital.of(hospital);
       if(hospital.getBusinessStatusCode() == 13){
           hospitalResponse.setBusinessStatusName("영업중");
       }else if(hospital.getBusinessStatusCode() == 3) {
           hospitalResponse.setBusinessStatusName("페업");
       }else{
           hospitalResponse.setBusinessStatusName(String.valueOf(hospital.getBusinessStatusCode()));
       }
       return hospitalResponse;
   }
}
