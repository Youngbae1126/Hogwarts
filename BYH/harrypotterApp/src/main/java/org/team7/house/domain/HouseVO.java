package org.team7.house.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// house 테이블을 위한 HouseVO 클래스 정의
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseVO {
    private Integer houseId;
    private String name;
    private String description;
    private String mascot;
}
