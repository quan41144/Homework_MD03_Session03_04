package ra.edu.java.coursemanagementsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.java.coursemanagementsystem.model.entity.Enrollment;
import ra.edu.java.coursemanagementsystem.repository.EnrollmentRepo;
import ra.edu.java.coursemanagementsystem.service.EnrollmentService;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepo<Enrollment> enrollmentRepo;
    @Autowired
    public EnrollmentServiceImpl(EnrollmentRepo<Enrollment> enrollmentRepo) {
        this.enrollmentRepo = enrollmentRepo;
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepo.findAll();
    }

    @Override
    public Enrollment getEnrollmentById(int id) {
        return enrollmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment with id " + id + " not found"));
    }

    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepo.create(enrollment);
    }

    @Override
    public Enrollment updateEnrollment(int id, Enrollment enrollment) {
        return enrollmentRepo.update(id, enrollment);
    }

    @Override
    public void deleteEnrollmentById(int id) {
        enrollmentRepo.deleteById(id);
    }
}
