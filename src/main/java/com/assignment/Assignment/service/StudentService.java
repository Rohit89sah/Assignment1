package com.assignment.Assignment.service;

import com.assignment.Assignment.model.Student;
import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(Long studId);
    List<Student> getAllStudents();
    Student updateStudent(Long studId, Student studentDetails);
    void deleteStudent(Long studId);
}

