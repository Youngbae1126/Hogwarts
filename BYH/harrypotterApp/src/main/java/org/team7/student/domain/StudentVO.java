package org.team7.student.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// student 테이블을 위한 StudentVO 클래스 정의
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentVO {
    private Integer id;
    private String name;
    private Integer grade;
    private String gender;
    private Integer houseId;
}
