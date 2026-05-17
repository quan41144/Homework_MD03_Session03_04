package ra.edu.java.coursemanagementsystem.repository;

import ra.edu.java.coursemanagementsystem.model.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepo<T> {
    List<Course> findAll();
    Optional<T> findById(int id);
    Course create(Course course);
    Course update(int id, Course course);
    void deleteById(int id);
}
