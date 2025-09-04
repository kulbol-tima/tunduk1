package kg.gov.mtsdr.ubk.web.dto.report;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

@Data
@Builder
public class MonthlyReportResponse {
    private YearMonth month;
    private int newApplications;
    private int approvedApplications;
    private int rejectedApplications;
    private BigDecimal totalAmountPaid;
    private List<ReportDetail> details;

    @Data
    @Builder
    public static class ReportDetail {
        private String region;
        private int applicationCount;
        private BigDecimal amountPaid;
    }
}
