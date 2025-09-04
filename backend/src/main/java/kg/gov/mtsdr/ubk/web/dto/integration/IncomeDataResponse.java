package kg.gov.mtsdr.ubk.web.dto.integration;

import kg.gov.mtsdr.ubk.integration.tunduk.dto.sf.SfPensionStatusResponse;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.sf.SfWorkPeriodsResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IncomeDataResponse {
    private SfPensionStatusResponse pensionStatus;
    private SfWorkPeriodsResponse workPeriods;
    // Placeholder for GNS data when it becomes available
    private Object patentInfo;
    private Object individualEntrepreneurInfo;
}
