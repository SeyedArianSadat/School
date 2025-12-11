package com.school.model.service;


import com.school.model.entity.Student;
import com.school.model.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

public class StudentService {
    public void save(Student student) throws Exception {
        StudentRepository repository = new StudentRepository();
        repository.save(student);
    }
    public void update(Student student) throws Exception {
        StudentRepository repository = new StudentRepository();
        repository.update(student);
    }
    public void deleteById(Long id) throws Exception {
        StudentRepository repository = new StudentRepository();
        repository.deleteById(id);
    }
    public Optional<Student> findById(Long id) throws Exception {
        StudentRepository repository = new StudentRepository();
        return repository.findById(id);
    }
    public List<Student> findAll() throws Exception {
        StudentRepository repository = new StudentRepository();
        return repository.findAll();
    }

}

