package ra.edu.java.coursemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.java.coursemanagementsystem.model.dto.response.ApiResponse;
import ra.edu.java.coursemanagementsystem.model.entity.Enrollment;
import ra.edu.java.coursemanagementsystem.service.EnrollmentService;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;
    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<Enrollment>>> getAllEnrollments(){
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Get all enrollments successfully!",
                enrollmentService.getAllEnrollments()
        ), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> getEnrollmentById(@PathVariable int id){
        try {
            return new ResponseEntity<>(new ApiResponse<>(
                    true,
                    "Get enrollment " + id + " successfully!",
                    enrollmentService.getEnrollmentById(id)
            ), HttpStatus.OK);
        }
        catch(RuntimeException e){
            return new ResponseEntity<>(new ApiResponse<>(
                    false,
                    e.getMessage(),
                    null
            ), HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Enrollment>> createEnrollment(@RequestBody Enrollment enrollment){
        try {
            return new ResponseEntity<>(new ApiResponse<>(
                    true,
                    "Create enrollment successfully!",
                    enrollmentService.createEnrollment(enrollment)
            ), HttpStatus.CREATED);
        }
        catch(RuntimeException e){
            return new ResponseEntity<>(new ApiResponse<>(
                    false,
                    e.getMessage(),
                    null
            ), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> updateEnrollment(@PathVariable int id, @RequestBody Enrollment enrollment){
        try {
            return new ResponseEntity<>(new ApiResponse<>(
                    true,
                    "Update enrollment " + id + " successfully!",
                    enrollmentService.updateEnrollment(id, enrollment)
            ), HttpStatus.OK);
        }
        catch(RuntimeException e){
            return new ResponseEntity<>(new ApiResponse<>(
                    false,
                    e.getMessage(),
                    null
            ), HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> deleteEnrollment(@PathVariable int id){
        try {
            return new ResponseEntity<>(new ApiResponse<>(
                    true,
                    "Delete enrollment successfully!",
                    null
            ), HttpStatus.OK);
        }
        catch(RuntimeException e){
            return new ResponseEntity<>(new ApiResponse<>(
                    false,
                    e.getMessage(),
                    null
            ), HttpStatus.NOT_FOUND);
        }
    }
}
