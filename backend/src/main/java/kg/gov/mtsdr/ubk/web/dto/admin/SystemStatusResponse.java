package kg.gov.mtsdr.ubk.web.dto.admin;

import lombok.Builder;
import lombok.Data;
import java.util.Map;

@Data
@Builder
public class SystemStatusResponse {
    private String databaseStatus;
    private String redisStatus;
    private Map<String, String> tundukServicesStatus;
}
