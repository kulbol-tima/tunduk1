package kg.gov.mtsdr.ubk.web.dto.admin;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class BaseValueUpdateRequest {
    @NotNull
    @Positive
    private BigDecimal baseValue;
}
