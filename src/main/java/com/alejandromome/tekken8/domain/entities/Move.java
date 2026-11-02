package com.alejandromome.tekken8.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@Entity
@Table(name = "Moves")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Move {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String command;

    @Column(nullable = false)
    private String hitLevel;

    @Column()
    private String damage;

    @Column(nullable = false)
    private String startFrame;

    @Column(nullable = false)
    private String hitFrame;

    @Column()
    private String blockFrame;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String notes;

    @Column()
    private Integer cleanBlockFrame;

    @Column()
    private Integer cleanStartUp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id")
    private Character character;
}
