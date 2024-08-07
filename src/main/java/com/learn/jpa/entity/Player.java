package com.learn.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")
    private Long id;

    private String name;

    private String position;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false) // JoinColumn es para indicar los valores en esta tabla y es en ¡singular!
    private Team team;

}
