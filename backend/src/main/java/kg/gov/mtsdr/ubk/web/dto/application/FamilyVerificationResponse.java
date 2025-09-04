package kg.gov.mtsdr.ubk.web.dto.application;

import lombok.Builder;
import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class FamilyVerificationResponse {

    private Long applicationId;
    private String overallStatus;
    private List<MemberVerificationStatus> memberStatuses;

    @Data
    @Builder
    public static class MemberVerificationStatus {
        private String pin;
        private String status;
        private Map<String, String> verificationDetails; // e.g., "GRS Passport": "OK", "MSEK": "NOT_FOUND"
    }
}
