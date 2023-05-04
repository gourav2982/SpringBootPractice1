package com.gourav.demo1.controller;
import com.gourav.demo1.Exceptions.StudentNotFound;
import com.gourav.demo1.collection.Student;
import com.gourav.demo1.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public Student saveStudent(@Valid @RequestBody Student student){
        return studentService.saveStudent(student);
    }


    @GetMapping("/get")
    public List<Student> getStudent(){
        return  studentService.findAllStudent();
    }

    @GetMapping("/get/{id}")
    public Student getStudentByid(@PathVariable("id") String name ) throws StudentNotFound {
        return studentService.getStudentByid(name);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id")String name){
            studentService.deleteStudent(name);
            return  "Successfully deleted";
    }
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable("id") String name, @RequestBody Student student){
        return studentService.updateStudent(name,student);
    }

}
