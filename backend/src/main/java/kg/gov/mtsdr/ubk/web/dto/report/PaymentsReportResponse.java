package kg.gov.mtsdr.ubk.web.dto.report;

import kg.gov.mtsdr.ubk.web.dto.payment.PaymentResponse;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class PaymentsReportResponse {
    private LocalDate fromDate;
    private LocalDate toDate;
    private int totalTransactions;
    private BigDecimal totalAmount;
    private Page<PaymentResponse> payments;
}
