package kg.gov.mtsdr.ubk.web.dto;

import lombok.Data;
import java.util.List;

@Data
public class PaymentOrderDto {
    private String orderId;
    private List<Long> recipientIds;
    // ... other payment order details
}
