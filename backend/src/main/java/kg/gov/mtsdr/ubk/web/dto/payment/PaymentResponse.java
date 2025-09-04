package kg.gov.mtsdr.ubk.web.dto.payment;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PaymentResponse {
    private Long id;
    private Long recipientId;
    private String recipientPin;
    private String recipientFullName;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String status;
    private LocalDateTime createdAt;
}
