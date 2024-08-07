package com.learn.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Competitions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameCompetition;

    @Column(name = "date_start")
    private LocalDate start;

    @Column(name = "date_end")
    private LocalDate end;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "team_competitions",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns =@JoinColumn(name = "competition_id")
    )
    private List<Team> teamsRegistered;

}
