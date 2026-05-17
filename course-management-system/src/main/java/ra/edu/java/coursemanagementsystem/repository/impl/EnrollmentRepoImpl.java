package ra.edu.java.coursemanagementsystem.repository.impl;

import org.springframework.stereotype.Repository;
import ra.edu.java.coursemanagementsystem.model.entity.Enrollment;
import ra.edu.java.coursemanagementsystem.repository.EnrollmentRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EnrollmentRepoImpl implements EnrollmentRepo<Enrollment> {
    List<Enrollment> enrollments = new ArrayList<>();

    public EnrollmentRepoImpl() {
        enrollments.add(new Enrollment(1001, "Nguyen Duc Hong Quan", 101));
        enrollments.add(new Enrollment(1002, "Le Van C", 103));
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollments;
    }

    @Override
    public Optional<Enrollment> findById(int id) {
        return enrollments.stream()
                .filter(enrollment -> enrollment.getId() == id)
                .findFirst();
    }

    @Override
    public Enrollment create(Enrollment enrollment) {
        Optional<Enrollment> existingEnrollment = findById(enrollment.getId());
        if (existingEnrollment.isPresent()) {
            throw new RuntimeException("Enrollment with id " + enrollment.getId() + " already exists");
        }
        enrollments.add(enrollment);
        return enrollment;
    }

    @Override
    public Enrollment update(int id, Enrollment enrollment) {
        Enrollment existingEnrollment = findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment with id " + id + " not found"));
        existingEnrollment.setStudentName(enrollment.getStudentName());
        existingEnrollment.setCourseId(enrollment.getCourseId());
        return existingEnrollment;
    }

    @Override
    public void deleteById(int id) {
        Enrollment existingEnrollment = findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment with id " + id + " not found"));
        enrollments.remove(existingEnrollment);
    }
}
