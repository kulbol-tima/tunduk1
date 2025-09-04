package kg.gov.mtsdr.ubk.web.dto.application;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class NewApplicationRequest {

    @NotBlank(message = "Applicant PIN is mandatory")
    private String applicantPin;

    @NotNull(message = "Family members cannot be null")
    @NotEmpty(message = "Family members cannot be empty")
    private List<String> familyMemberPins;

    // Other application fields would go here, for example:
    private String comments;
}
