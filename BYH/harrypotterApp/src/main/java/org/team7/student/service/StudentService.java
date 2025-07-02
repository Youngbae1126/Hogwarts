package org.team7.student.service;
import org.team7.student.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStd();
    StudentDTO getStd(int id);
    void addStd(StudentDTO studentDTO);
    boolean updStd(StudentDTO studentDTO);
    boolean delStd(int id);
}