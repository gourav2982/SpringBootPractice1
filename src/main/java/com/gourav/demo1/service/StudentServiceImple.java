package com.gourav.demo1.service;

import com.gourav.demo1.Exceptions.StudentNotFound;
import com.gourav.demo1.collection.Student;
import com.gourav.demo1.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImple implements StudentService{
    @Autowired
    StudentRepo repo;
    @Override
    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public List<Student> findAllStudent() {
        return repo.findAll();
    }

    @Override
    public void deleteStudent(String name) {
        repo.deleteById(name);
    }

    @Override
    public Student updateStudent(String name, Student student) {
        Student stdb = repo.findById(name).get();

        if(Objects.nonNull(student.getLastname())&&!"".equalsIgnoreCase(student.getLastname())){
            stdb.setLastname(student.getLastname());
        }
        if(Objects.nonNull(student.getEmail())&&!"".equalsIgnoreCase(student.getEmail())){
            stdb.setEmail(student.getEmail());
        }
        return repo.save(stdb);
    }

    @Override
    public Student getStudentByid(String name) throws StudentNotFound {
        Optional<Student> student = repo.findById(name);
        if(!student.isPresent()){
            throw new StudentNotFound("Student Not Found");
        }
        else
          return student.get();
    }


}
