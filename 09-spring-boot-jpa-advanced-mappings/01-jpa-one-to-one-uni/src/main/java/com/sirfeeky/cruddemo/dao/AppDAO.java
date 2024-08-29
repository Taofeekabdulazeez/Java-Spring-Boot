package com.sirfeeky.cruddemo.dao;

import com.sirfeeky.cruddemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);
    
    void deleteInstructorById(int id);
}
