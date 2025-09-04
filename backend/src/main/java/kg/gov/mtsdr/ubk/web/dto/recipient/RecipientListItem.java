package kg.gov.mtsdr.ubk.web.dto.recipient;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class RecipientListItem {
    private Long id;
    private String pin;
    private String fullName;
    private String status;
    private BigDecimal currentBenefitAmount;
}
