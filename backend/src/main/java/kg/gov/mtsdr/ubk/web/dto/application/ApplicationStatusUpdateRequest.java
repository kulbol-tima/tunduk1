package kg.gov.mtsdr.ubk.web.dto.application;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ApplicationStatusUpdateRequest {
    @NotBlank(message = "Status cannot be blank")
    private String status;
    private String reason; // Optional reason for status change
}
