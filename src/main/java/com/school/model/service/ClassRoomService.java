package com.school.model.service;

import com.school.model.entity.ClassRoom;
import com.school.model.repository.ClassRoomRepository;

import java.util.List;
import java.util.Optional;


public class ClassRoomService {
    public void save(ClassRoom classRoom) throws Exception {
        ClassRoomRepository repository = new ClassRoomRepository();
        repository.save(classRoom);
    }
    public void update(ClassRoom classRoom) throws Exception {
        ClassRoomRepository repository = new ClassRoomRepository();
        repository.save(classRoom);
    }
    public void deleteById(Long id) throws Exception {
        ClassRoomRepository repository = new ClassRoomRepository();
        repository.deleteById(id);
    }
    public Optional<ClassRoom> findById(Long id) throws Exception {
        ClassRoomRepository repository = new ClassRoomRepository();
        return repository.findById(id);
    }
    public List<ClassRoom> findAll() throws Exception {
        ClassRoomRepository repository = new ClassRoomRepository();
        return repository.findAll();
    }

}
