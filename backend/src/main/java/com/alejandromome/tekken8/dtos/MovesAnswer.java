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
    private Long id;
    private String name;
    private String command;
    private String hitLevel;
    private String damage;
    private String startFrame;
    private String blockFrame;
    private String notes;

}
