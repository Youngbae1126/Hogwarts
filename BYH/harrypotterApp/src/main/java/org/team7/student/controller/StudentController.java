package org.team7.student.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.team7.exception.ApiResponse;
import org.team7.student.dto.StudentDTO;
import org.team7.student.service.StudentService;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    final private StudentService service;

    // GET :: /api/students
    @GetMapping("")
    public ResponseEntity<List<StudentDTO>> getAllStdList() {
        log.info("========================> 전체 학생 조회");

        return ResponseEntity.ok(service.getAllStd());
    }

    // GET :: /api/students/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentDTO>> getStd(@PathVariable int id) {
        log.info("========================> 아이디로 학생 1명 조회" + id);
        try {
            StudentDTO findByIdStudent = service.getStd(id);
            ApiResponse<StudentDTO> response = ApiResponse.success("아이디에 맞는 학생 정보를 찾았습니다.", findByIdStudent);
            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            log.info("아이디 : {}에 해당하는 학생 정보를 찾지 못했습니다." , id);
            ApiResponse<StudentDTO> response = ApiResponse.failure("아이디 " + id + "에 해당하는 학생 정보를 찾지 못했습니다.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

    // POST :: /api/students
    @PostMapping("")
    public ResponseEntity<ApiResponse<StudentDTO>> addStd(@RequestBody StudentDTO studentDTO) {
        log.info("=========================> 학생 추가하기");
        log.info("받은 학생 정보 : {}", studentDTO);

        try{
            service.addStd(studentDTO);
            ApiResponse<StudentDTO> response = ApiResponse.success("정상적으로 추가되었습니다.", studentDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            log.error("학생 추가 실패: ", e);
            ApiResponse<StudentDTO> response = ApiResponse.failure("학생 정보 추가에 실패했습니다.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

        // 201 Created 상태코드와 함께 생성된 학생 정보 반환
        // return ResponseEntity.status(HttpStatus.CREATED).body(studentDTO);

    }


    // PUT :: /api/students/{id}
    @PutMapping("/{id}")
    public ResponseEntity<String> upStd(@PathVariable int id, @RequestBody StudentDTO studentDTO) {
        log.info("=========================> 학생 정보 수정하기");
        studentDTO.setId(id);
        log.info("변경할 학생 아이디: {}, 변경할 학생 정보: {}", id, studentDTO);

        try{
            service.updStd(studentDTO);
            return ResponseEntity.status(HttpStatus.OK).body("정상적으로 수정되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("수정에 실패했습니다.");
        }
    }

    // DELETE :: /api/students/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delStd(@RequestParam("id") int id) {
        log.info("=========================> 학생 정보 삭제하기");
        log.info("삭제 할 아이디: {}" , id);
        try{
            service.delStd(id);
            return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제에 실패했습니다.");
        }
    }
}
