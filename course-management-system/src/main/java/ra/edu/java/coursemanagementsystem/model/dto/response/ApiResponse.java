package ra.edu.java.coursemanagementsystem.model.dto.response;

import lombok.*;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
}
