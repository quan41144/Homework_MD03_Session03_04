package ra.edu.java.coursemanagementsystem.service;

import ra.edu.java.coursemanagementsystem.model.entity.Enrollment;

import java.util.List;

public interface EnrollmentService {
    List<Enrollment> getAllEnrollments();
    Enrollment getEnrollmentById(int id);
    Enrollment createEnrollment(Enrollment enrollment);
    Enrollment updateEnrollment(int id, Enrollment enrollment);
    void deleteEnrollmentById(int id);
}
