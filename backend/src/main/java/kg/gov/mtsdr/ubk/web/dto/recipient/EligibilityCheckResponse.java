package kg.gov.mtsdr.ubk.web.dto.recipient;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class EligibilityCheckResponse {
    private boolean isEligible;
    private BigDecimal potentialBenefitAmount;
    private List<String> reasons;
}
