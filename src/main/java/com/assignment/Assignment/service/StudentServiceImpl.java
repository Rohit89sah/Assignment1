package com.assignment.Assignment.service;

import com.assignment.Assignment.exception.ResourceNotFoundException;
import com.assignment.Assignment.model.Student;
import com.assignment.Assignment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long studId) {
        return studentRepository.findById(studId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studId));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Long studId, Student studentDetails) {
        Student student = getStudentById(studId);
        student.setStudName(studentDetails.getStudName());
        student.setStudAge(studentDetails.getStudAge());
        student.setStudCity(studentDetails.getStudCity());
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studId) {
        Student student = getStudentById(studId);
        studentRepository.delete(student);
    }
}

