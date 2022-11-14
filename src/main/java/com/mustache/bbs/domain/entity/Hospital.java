package com.mustache.bbs.domain.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="national_hospitals")
@Getter
public class Hospital {
    @Id
    private Integer id; // 이미 id있으므로 GeneratedValue 사용x

    @Column(name="road_name_address")
    private String roadNameAddress;

    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "business_type_name")
    private String businessTypeName;

}
