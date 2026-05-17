package ra.edu.java.coursemanagementsystem.model.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Enrollment {
    private int id;
    private String studentName;
    private int courseId;
}
