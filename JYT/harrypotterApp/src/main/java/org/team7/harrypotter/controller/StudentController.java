package org.team7.harrypotter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.team7.harrypotter.dto.StudentDTO;
import org.team7.harrypotter.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // 학생 등록
    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO) {
        studentService.addStudent(studentDTO);
        return ResponseEntity.ok("학생이 등록되었습니다.");
    }

    // 전체 학생 조회
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // 특정 학생 조회
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    // 학생 정보 수정
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Integer id, @RequestBody StudentDTO studentDTO) {
        studentDTO.setId(id);
        studentService.updateStudent(studentDTO);
        return ResponseEntity.ok("학생 정보가 수정되었습니다.");
    }

    // 학생 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("학생이 삭제되었습니다.");
    }

    // 특정 기숙사 소속 학생 목록 조회
    @GetMapping("/house/{houseId}")
    public ResponseEntity<List<StudentDTO>> getStudentsByHouse(@PathVariable Integer houseId) {
        return ResponseEntity.ok(studentService.getStudentsByHouse(houseId));
    }
}