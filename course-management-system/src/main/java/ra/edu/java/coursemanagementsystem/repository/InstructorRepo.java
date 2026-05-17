package ra.edu.java.coursemanagementsystem.repository;

import ra.edu.java.coursemanagementsystem.model.entity.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorRepo<T> {
    List<Instructor> findAll();
    Optional<T> findById(int id);
    Instructor create(Instructor instructor);
    Instructor update(int id, Instructor instructor);
    void deleteById(int id);
}
