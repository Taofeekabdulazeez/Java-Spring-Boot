package com.sirfeeky.cruddemo.dao;

import com.sirfeeky.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements  StudentDao{

    // define field for entity manager
    private final EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // implement sava method
    @Override
    @Transactional
    public void save(Student student) {
        this.entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return this.entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> query = this.entityManager.createQuery("FROM Student order by lastName", Student.class);

        // return query results
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create query
        TypedQuery<Student> query = this.entityManager.createQuery("FROM Student WHERE lastName=:lastName", Student.class);

        // set query parameters
        query.setParameter("lastName", lastName);

        // return query results
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        this.entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // find the student by the id
        //Student student = this.findById(id);
        Student student = this.entityManager.find(Student.class, id);

        // delete the student
        this.entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return this.entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }


}
