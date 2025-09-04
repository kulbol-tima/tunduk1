package kg.gov.mtsdr.ubk.web.dto.admin;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Map;

@Data
public class CoefficientUpdateRequest {
    @NotEmpty
    private Map<String, BigDecimal> coefficients;
}
