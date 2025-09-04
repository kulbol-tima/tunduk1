package kg.gov.mtsdr.ubk.web.dto.application;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ApplicationResponse {
    private Long id;
    private String applicantPin;
    private List<String> familyMemberPins;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String comments;
}
