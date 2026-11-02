package com.alejandromome.tekken8.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovesAnswer {
    private String name;
    private String command;
    private String hitLevel;
    private Long damage;
    private Long startFrame;
    private Long blockFrame;
    private String notes;
}
