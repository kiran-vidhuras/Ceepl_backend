package com.vidhuras.ceepl.entity;

import com.vidhuras.ceepl.dto.HomeResponseDto;
import com.vidhuras.ceepl.dto.ServiceResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="home_services")
public class HomeService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "service_name", nullable = false)
    private String serviceName;

    @Column(name = "icon")
    private String icon;

    @Column(name = "sub_name")
    private String subName;

    @Column(name = "description")
    private String description;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_ip")
    private String createdIp;

    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_ip")
    private String modifiedIp;

    private String status;



}
