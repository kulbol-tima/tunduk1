package kg.gov.mtsdr.ubk.web.dto.payment;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BankTransferResponse {
    private String batchId;
    private String status;
    private int paymentCount;
    private LocalDateTime transferTimestamp;
}
