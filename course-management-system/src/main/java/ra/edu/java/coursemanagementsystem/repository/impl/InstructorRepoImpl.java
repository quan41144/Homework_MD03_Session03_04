package ra.edu.java.coursemanagementsystem.repository.impl;

import org.springframework.stereotype.Repository;
import ra.edu.java.coursemanagementsystem.model.entity.Instructor;
import ra.edu.java.coursemanagementsystem.repository.InstructorRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InstructorRepoImpl implements InstructorRepo<Instructor> {
    List<Instructor> instructors = new ArrayList<>();

    public InstructorRepoImpl() {
        instructors.add(new Instructor(1, "Nguyen Van A", "a.nguyen@email.com"));
        instructors.add(new Instructor(2, "Tran Thi B", "b.tran@email.com"));
    }

    @Override
    public List<Instructor> findAll() {
        return instructors;
    }

    @Override
    public Optional<Instructor> findById(int id) {
        return instructors.stream()
                .filter(instructor -> instructor.getId() == id)
                .findFirst();
    }

    @Override
    public Instructor create(Instructor instructor) {
        Optional<Instructor> existingInstructor = findById(instructor.getId());
        if (existingInstructor.isPresent()) {
            throw new RuntimeException("Instructor with id " + instructor.getId() + " not found");
        }
        instructors.add(instructor);
        return instructor;
    }

    @Override
    public Instructor update(int id, Instructor instructor) {
        Instructor existingInstructor = findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor with id " + id + " not found"));
        existingInstructor.setName(instructor.getName());
        existingInstructor.setEmail(instructor.getEmail());
        return existingInstructor;
    }

    @Override
    public void deleteById(int id) {
        Instructor existingInstructor = findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor with id " + id + " not found"));
        instructors.remove(existingInstructor);
    }
}
