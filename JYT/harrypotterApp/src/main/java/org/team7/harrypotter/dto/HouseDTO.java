package org.team7.harrypotter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseDTO {

    private Integer houseId;
    private String name;
    private String description;
    private String mascot;
    
}