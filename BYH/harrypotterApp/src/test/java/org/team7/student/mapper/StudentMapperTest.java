package org.team7.student.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.team7.config.RootConfig;
import org.team7.student.domain.StudentVO;

import java.util.List;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class StudentMapperTest {
    @Autowired
    private StudentMapper stdMapper;

    @Test
    @DisplayName("StudentMapper의 목록 불러오기")
    public void getAllStd(){
        List<StudentVO> studentList = stdMapper.getAllStd();

        log.info("============ 전체 학생 목록 가져오기 ============");
        log.info("전체 학생 수 : {} 명", studentList.size());

        for(StudentVO studentVO : studentList) {
            log.info("{}", studentVO);
        }
    }

    @Test
    @DisplayName("id 값에 해당하는 학생 목록 불러오기")
    public void getStd(){
        int id = 1; // 조회 할 아이디

        log.info("============ 아이디에 해당하는 학생 목록 가져오기 ============");
        log.info("조회 할 아이디 : {}", id);

        StudentVO student = stdMapper.getStd(id);
        log.info("아이디가 {}인 학생 목록 : {}", id, student);
    }

    @Test
    @DisplayName("학생 추가하기")
    public void addStd(){
        // 새로운 학생 정보
        StudentVO newStd = new StudentVO(
                null, "차은우", 5, "Male", 4
        );

        log.info("============ 학생 추가하기 ============");
        log.info("추가할 학생 정보 : {}", newStd);

        stdMapper.addStd(newStd);

        log.info("============ 추가되었는 지 확인 ============");
        log.info("전체 학생 수 : {} 명", stdMapper.getAllStd().size());
    }

    @Test
    @DisplayName("학생 정보 수정하기")
    public void updStd(){
        log.info("============ 학생 정보 수정하기 ============");
        // 수정할 학생 id
        int updStdID = 11;

        // 기존 학생 정보 가져오기
        StudentVO updStd = stdMapper.getStd(updStdID);
        log.info("수정 전 학생 정보 : {}", updStd);

        // 수정할 학생 정보
        updStd.setName("지창욱");

        int count = stdMapper.updStd(updStd);

        log.info("수정된 학생 수 : {}", count);
        log.info("수정된 학생 정보 : {}", updStd);
    }

    @Test
    @DisplayName("학생 정보 삭제하기")
    public void delStd(){
        log.info("============ 학생 정보 삭제하기 ============");
        int delId = 11;

        stdMapper.delStd(delId);
        log.info("전체 학생 수 : {} 명", stdMapper.getAllStd().size());
    }

}