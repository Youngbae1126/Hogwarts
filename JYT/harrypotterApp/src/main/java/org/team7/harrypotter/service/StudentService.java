package org.team7.harrypotter.service;

import org.team7.harrypotter.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    void addStudent(StudentDTO student);

    List<StudentDTO> getAllStudents();

    StudentDTO getStudent(Integer id);

    void updateStudent(StudentDTO student);

    void deleteStudent(Integer id);

    List<StudentDTO> getStudentsByHouse(Integer houseId);
    
}