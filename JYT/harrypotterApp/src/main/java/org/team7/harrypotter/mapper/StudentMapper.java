package org.team7.harrypotter.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.team7.harrypotter.dto.StudentDTO;

import java.util.List;

@Mapper
public interface StudentMapper {

    void insertStudent(StudentDTO student);

    List<StudentDTO> selectAllStudents();

    StudentDTO selectStudentById(Integer id);

    void updateStudent(StudentDTO student);

    void deleteStudent(Integer id);

    List<StudentDTO> selectStudentsByHouseId(Integer houseId);
    
}