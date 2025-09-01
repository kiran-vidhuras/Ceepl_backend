package com.vidhuras.ceepl.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "about")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class About<A> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "heading")
    private String heading;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "button_text")
    private String buttonText;

    @Column(name = "image_path")
    private String imagePath;

    @Column(columnDefinition = "TEXT")
    private String content;
}
