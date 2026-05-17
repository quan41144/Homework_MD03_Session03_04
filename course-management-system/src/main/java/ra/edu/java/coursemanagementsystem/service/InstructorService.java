package ra.edu.java.coursemanagementsystem.service;

import ra.edu.java.coursemanagementsystem.model.entity.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors();
    Instructor getInstructorById(int id);
    Instructor createInstructor(Instructor instructor);
    Instructor updateInstructor(int id, Instructor instructor);
    void deleteInstructorById(int id);
}
