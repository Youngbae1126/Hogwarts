package org.team7.student.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.team7.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.team7.student.dto.StudentDTO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class} )
@Log4j2
class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void getAllStd() {
        for(StudentDTO studentDTO : studentService.getAllStd()) {
            log.info(studentDTO);
        }
    }

    @Test
    void getStd() {
        log.info(studentService.getStd(1));
    }

    @Test
    public void addStd() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName("전지현");
        studentDTO.setGender("Female");
        studentDTO.setGrade(5);
        studentDTO.setHouseId(3);

        studentService.addStd(studentDTO);

        log.info("새로 생성된 학생 정보 : " + studentDTO.getId());
    }

        @Test
        void updStd() {
        StudentDTO studentDTO = studentService.getStd(13);
        studentDTO.setName("변우석");
        log.info("update RESULT: " + studentService.updStd(studentDTO));
    }

        @Test
        public void delStd() {
    // 게시물 번호의 존재 여부를 확인하고 테스트할 것
        log.info("delete RESULT: " + studentService.delStd(13));
    }

}