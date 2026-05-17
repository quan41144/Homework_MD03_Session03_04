package ra.edu.java.coursemanagementsystem.repository;

import ra.edu.java.coursemanagementsystem.model.entity.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepo<T> {
    List<Enrollment> findAll();
    Optional<T> findById(int id);
    Enrollment create(Enrollment enrollment);
    Enrollment update(int id, Enrollment enrollment);
    void deleteById(int id);
}
