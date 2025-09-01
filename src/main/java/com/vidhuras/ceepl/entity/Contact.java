package com.vidhuras.ceepl.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "contact_us")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phone;
    private String state;
    private String country;
    private String message;


    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "created_ip")
    private String createdIp;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

    @Column(name = "modified_ip")
    private String modifiedIp;

    @Column(name = "modified_at")
    private String modifiedAt;

    @Column(name = "status")
    private String status;


}
