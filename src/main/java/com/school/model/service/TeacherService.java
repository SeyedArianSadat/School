package com.school.model.service;

import com.school.model.entity.Teacher;
import com.school.model.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

public class TeacherService {
    public void save(Teacher teacher) throws Exception {
        TeacherRepository repository = new TeacherRepository();
        repository.save(teacher);
    }
    public void update(Teacher teacher) throws Exception {
        TeacherRepository repository = new TeacherRepository();
        repository.update(teacher);
    }
    public void deleteById(Long id) throws Exception {
        TeacherRepository repository = new TeacherRepository();
        repository.deleteById(id);
    }
    public Optional<Teacher> findById(Long id) throws Exception {
        TeacherRepository repository = new TeacherRepository();
        return repository.findById(id);
    }
    public List<Teacher> findAll() throws Exception {
        TeacherRepository repository = new TeacherRepository();
        return repository.findAll();
    }

}

