package com.vidhuras.ceepl.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "menus")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = true)
    private String subName;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String status;
}

