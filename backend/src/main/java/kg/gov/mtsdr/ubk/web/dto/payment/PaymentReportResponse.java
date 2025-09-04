package kg.gov.mtsdr.ubk.web.dto.payment;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class PaymentReportResponse {
    private LocalDate reportDate;
    private int totalPayments;
    private BigDecimal totalAmount;
    private String generatedBy;
}
