package com.sirfeeky.cruddemo.dao;

import com.sirfeeky.cruddemo.entity.Course;
import com.sirfeeky.cruddemo.entity.Instructor;
import com.sirfeeky.cruddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {
    // define field for manager
    private final EntityManager entityManager;

    // inject entity manager using constructor injection


    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        this.entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return this.entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        // retrieve the courses
        Instructor instructor = this.entityManager.find(Instructor.class, id);

        // get the courses
        List<Course> courses = instructor.getCourses();

        // break association of all courses for the instructor
        for (Course course : courses) {
            course.setInstructor(null);
        }

        this.entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {

        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        // retrieve the instructor detail by id
        InstructorDetail instructorDetail = this.entityManager.find(InstructorDetail.class, id);

        // remove the associated object reference
        // break bi-directional link
        instructorDetail.getInstructor().setInstructorDetail(null);

        // delete the instructor detail
        this.entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        // create query
        TypedQuery<Course> query = this.entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class);

        query.setParameter("data", id);

        // execute query
        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        // create query
        TypedQuery<Instructor> query = this.entityManager.createQuery(
                        "select i from Instructor i "
                        + "JOIN FETCH i.courses "
                         + "JOIN FETCH i.instructorDetail "
                         + "where i.id = :data",
                Instructor.class);

        query.setParameter("data", id);
        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        this.entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        this.entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        Course course = this.entityManager.find(Course.class, id);

        return course;
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        // retrieve the course
        Course course = this.entityManager.find(Course.class, id);

        this.entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
      this.entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {
        // create query
        TypedQuery<Course> query = this.entityManager.createQuery(
                "select c from Course c "
                + "JOIN FETCH c.reviews "
                + "where c.id = :data", Course.class
        );

        query.setParameter("data", id);

        Course course = query.getSingleResult();

        return course;
    }
}
