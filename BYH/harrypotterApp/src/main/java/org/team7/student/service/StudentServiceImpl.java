package org.team7.student.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.team7.student.domain.StudentVO;
import org.team7.student.dto.StudentDTO;
import org.team7.student.mapper.StudentMapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    final private StudentMapper studentMapper;

    @Override
    public List<StudentDTO> getAllStd() {
//        log.info("모든 학생 리스트 가져오기");
        return studentMapper.getAllStd().stream()
                .map(StudentDTO::of)
                .toList();
    }

    @Override
    public StudentDTO getStd(int id) {
        log.info("==================> id에 해당하는 학생 정보 가져오기   " + id);

        StudentDTO studentDTO = StudentDTO.of(studentMapper.getStd(id));

        return Optional.ofNullable(studentDTO)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void addStd(StudentDTO studentDTO) {
        log.info("==================> 학생 추가하기   " + studentDTO);

        StudentVO vo = studentDTO.toVo();
        studentMapper.addStd(vo);
        studentDTO.setId(vo.getId());
    }

    @Override
    public boolean updStd(StudentDTO studentDTO) {
        log.info("==================> update" + studentDTO);

        StudentVO vo = studentDTO.toVo();
        return studentMapper.updStd(vo) == 1;
    }

    @Override
    public boolean delStd(int id) {
        log.info("==================> delete    id : " + id);

        return studentMapper.delStd(id) == 1;
    }
}
