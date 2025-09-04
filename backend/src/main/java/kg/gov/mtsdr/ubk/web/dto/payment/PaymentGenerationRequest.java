package kg.gov.mtsdr.ubk.web.dto.payment;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class PaymentGenerationRequest {
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate period; // e.g., "2023-10-01" for October 2023 payments

    private String paymentType; // e.g., "REGULAR", "ONE_TIME"
}
