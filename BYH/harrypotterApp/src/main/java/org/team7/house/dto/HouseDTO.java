package org.team7.house.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.team7.house.domain.HouseVO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseDTO {
    private Integer houseId;
    private String name;
    private String description;
    private String mascot;

    // VO -> DTO 변환 (of())
    // 복잡하지도 않고, 순서도 상관없이 값을 넣어서 객체를 만들고자 하는 방법
    // Builder 객체 이용
    public static HouseDTO of(HouseVO vo) {
        return vo == null ? null : HouseDTO.builder()
                .houseId(vo.getHouseId())
                .name(vo.getName())
                .description(vo.getDescription())
                .mascot(vo.getMascot())
                .build();
    }

    // DTO -> VO 변환
    public HouseVO toVo() {
        return HouseVO.builder()
                .houseId(houseId)
                .name(name)
                .description(description)
                .mascot(mascot)
                .build();
    }
}
