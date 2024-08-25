package com.sirfeeky.cruddemo.dao;

import com.sirfeeky.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();
}
