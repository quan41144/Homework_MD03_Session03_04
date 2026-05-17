package ra.edu.java.coursemanagementsystem.service;

import ra.edu.java.coursemanagementsystem.model.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(int id);
    Course createCourse(Course course);
    Course updateCourse(int id, Course course);
    void deleteCourseById(int id);
}
