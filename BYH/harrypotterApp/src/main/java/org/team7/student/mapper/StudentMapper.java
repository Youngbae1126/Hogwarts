package org.team7.student.mapper;

import org.team7.student.domain.StudentVO;

import java.util.List;

public interface StudentMapper {

    // 전체 학생 조회(검색)
    List<StudentVO> getAllStd();

    // 아이디로 특정 학생 조회
    StudentVO getStd(int id);

    // 학생 정보 추가
    void addStd(StudentVO student);

    // 학생 정보 수정
    int updStd(StudentVO student);

    // 학생 정보 삭제
    int delStd(int id);
}
