package com.vidhuras.ceepl.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String image;

    private LocalDate date;

    private String category;

    @Column(length = 2000)
    private String description;

    private String status = "ACTIVE";


}

