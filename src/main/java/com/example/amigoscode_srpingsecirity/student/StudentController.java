package com.example.amigoscode_srpingsecirity.student;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anns Smith")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " doesnt exist"));
    }
//
//    @PostMapping()
//    public Student createStudent(@RequestBody Student student) {
//        STUDENTS.add(student);
//        return student;
//    }
//
//    @PutMapping(path = "{studentId}")
//    public Student updateStudent(@RequestParam String studentName,
//                                 @PathVariable("studentId") Integer studentId
//    ) {
//        Student student = STUDENTS.get(studentId - 1);
//        student.setStudentName(studentName);
//        return student;
//    }
//
//    @DeleteMapping(path = "{studentId}")
//    public boolean deleteStudent(@PathVariable("studentId") Integer studentId) {
//        return STUDENTS.remove(STUDENTS.get(studentId - 1));
//    }
}
