package com.gourav.demo1.service;

import com.gourav.demo1.Exceptions.StudentNotFound;
import com.gourav.demo1.collection.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
   public Student saveStudent(Student student);


  public List<Student> findAllStudent();

    public void deleteStudent(String name);


    public Student updateStudent(String name, Student student);

    public Student getStudentByid(String name) throws StudentNotFound;
}
