package com.learn.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //Como nota checar como hacer serial la PK
    @Column(name = "team_id")
    private Long id;
    private String name;
    //Here we have an association One To Many
    // One Team have Many players
    @OneToMany(targetEntity = Player.class, fetch = FetchType.LAZY,
    cascade = CascadeType.ALL, mappedBy = "team")
    private List<Player> players;

    @ManyToMany(mappedBy = "teamsRegistered")
    private List<Competitions> competitions;

}
