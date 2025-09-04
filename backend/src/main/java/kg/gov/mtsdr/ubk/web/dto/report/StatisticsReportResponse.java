package kg.gov.mtsdr.ubk.web.dto.report;

import lombok.Builder;
import lombok.Data;
import java.util.Map;

@Data
@Builder
public class StatisticsReportResponse {
    private long totalRecipients;
    private long activeRecipients;
    private Map<String, Long> recipientsByRegion;
    private Map<String, Long> recipientsByStatus;
}
