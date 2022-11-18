package com.mustache.bbs.service;

import com.mustache.bbs.domain.dto.HospitalResponse;
import com.mustache.bbs.domain.entity.Hospital;
import com.mustache.bbs.repository.HospitalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

class HospitalServiceTest {
    private final HospitalRepository hospitalRepository = Mockito.mock(HospitalRepository.class);
    private HospitalService hospitalService;

    @BeforeEach
    void setUp(){
        hospitalService = new HospitalService(hospitalRepository);
    }

    @Test
    @DisplayName("business_code가 3일때 폐업")
    void businessStatusName3(){
        Hospital hospital = Hospital.builder()
                .id(718457)
                .businessStatusCode(3)
                .build();
        Mockito.when(hospitalRepository.findById(any()))
                .thenReturn(Optional.of(hospital));

        HospitalResponse response = hospitalService.getHospital(718457);
        assertThat(response.getBusinessStatusName()).isEqualTo("폐업");
    }

    @Test
    @DisplayName("business_code가 13일때 영업중")
    void businessStatusName13(){
        Hospital hospital = Hospital.builder()
                .id(4)
                .businessStatusCode(13)
                .build();
        Mockito.when(hospitalRepository.findById(4))
                .thenReturn(Optional.of(hospital));
        HospitalResponse response = hospitalService.getHospital(4);
        assertThat(response.getBusinessStatusName()).isEqualTo("영업중");
    }

}