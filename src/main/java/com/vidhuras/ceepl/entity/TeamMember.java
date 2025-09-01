package com.vidhuras.ceepl.entity;


import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="team_member")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String designation;
    private String image;
}
