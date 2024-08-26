package com.sirfeeky.demo.rest;

import com.sirfeeky.demo.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Taofeek", "Abdulazeez"));
        students.add(new Student("Abdullah", "Awwal"));
        students.add(new Student("Yusuf", "Balogun"));

        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Taofeek", "Abdulazeez"));
        students.add(new Student("Abdullah", "Awwal"));
        students.add(new Student("Yusuf", "Balogun"));

        if (studentId > students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student not found: "+studentId);
        }

        return students.get(studentId);
    }


}


