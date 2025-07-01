package org.team7.harrypotter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.team7.harrypotter.dto.StudentDTO;
import org.team7.harrypotter.mapper.StudentMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    @Override
    public void addStudent(StudentDTO student) {
        studentMapper.insertStudent(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentMapper.selectAllStudents();
    }

    @Override
    public StudentDTO getStudent(Integer id) {
        return studentMapper.selectStudentById(id);
    }

    @Override
    public void updateStudent(StudentDTO student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentMapper.deleteStudent(id);
    }

    @Override
    public List<StudentDTO> getStudentsByHouse(Integer houseId) {
        return studentMapper.selectStudentsByHouseId(houseId);
    }
}