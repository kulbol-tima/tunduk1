package kg.gov.mtsdr.ubk.web.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class RegionDataDto {
    private String regionCode;
    private BigDecimal regionCoefficient;
    // ... other region-specific data
}
