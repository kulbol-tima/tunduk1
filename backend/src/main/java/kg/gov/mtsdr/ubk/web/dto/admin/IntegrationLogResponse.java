package kg.gov.mtsdr.ubk.web.dto.admin;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class IntegrationLogResponse {
    private Long id;
    private LocalDateTime timestamp;
    private String serviceName;
    private String requestPin;
    private String status;
    private String errorMessage;
    private long durationMs;
}
