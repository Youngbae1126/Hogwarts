package org.team7.student.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.team7.student.domain.StudentVO;
import org.team7.student.domain.StudentVO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
    private Integer id;
    private String name;
    private Integer grade;
    private String gender;
    private Integer houseId;

    // VO -> DTO 변환 (of())
    // 복잡하지도 않고, 순서도 상관없이 값을 넣어서 객체를 만들고자 하는 방법
    // Builder 객체 이용
    public static StudentDTO of(StudentVO vo) {
        return vo == null ? null : StudentDTO.builder()
                .id(vo.getId())
                .name(vo.getName())
                .grade(vo.getGrade())
                .gender(vo.getGender())
                .houseId(vo.getHouseId())
                .build();
    }

    // DTO -> VO 변환
    public StudentVO toVo() {
        return StudentVO.builder()
                .id(id)
                .name(name)
                .grade(grade)
                .gender(gender)
                .houseId(houseId)
                .build();

    }
}

