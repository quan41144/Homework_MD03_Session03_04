package ra.edu.java.coursemanagementsystem.repository.impl;

import org.springframework.stereotype.Repository;
import ra.edu.java.coursemanagementsystem.model.entity.Course;
import ra.edu.java.coursemanagementsystem.repository.CourseRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepoImpl implements CourseRepo<Course> {
    List<Course> courses = new ArrayList<>();
    public CourseRepoImpl() {
        courses.add(new Course(101, "Java BootCamp", "Active", 1));
        courses.add(new Course(102, "Web Development", "Pending", 1));
        courses.add(new Course(103, "Database Design", "Active", 2));
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public Optional<Course> findById(int id) {
        return courses.stream()
                .filter(course -> course.getId() == id)
                .findFirst();
    }

    @Override
    public Course create(Course course) {
        Optional<Course> existingCourse = findById(course.getId());
        if (existingCourse.isPresent()) {
            throw new RuntimeException("Course with id " + course.getId() + " already exists");
        }
        courses.add(course);
        return course;
    }

    @Override
    public Course update(int id, Course course) {
        Course existingCourse = findById(id)
                .orElseThrow(() -> new RuntimeException("Course with id " + id + " not found"));
        existingCourse.setTitle(course.getTitle());
        existingCourse.setStatus(course.getStatus());
        existingCourse.setInstructorId(course.getInstructorId());
        return existingCourse;
    }

    @Override
    public void deleteById(int id) {
        Course existingCourse = findById(id)
                .orElseThrow(() -> new RuntimeException("Course with id " + id + " not found"));
        courses.remove(existingCourse);
    }
}
