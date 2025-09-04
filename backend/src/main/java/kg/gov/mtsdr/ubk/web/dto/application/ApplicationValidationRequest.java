package kg.gov.mtsdr.ubk.web.dto.application;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class ApplicationValidationRequest {
    @NotBlank(message = "Applicant PIN is mandatory")
    private String applicantPin;
    private List<String> familyMemberPins;
    // Add other fields that need to be validated
}
