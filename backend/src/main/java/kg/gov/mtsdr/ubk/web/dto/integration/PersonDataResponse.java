package kg.gov.mtsdr.ubk.web.dto.integration;

import kg.gov.mtsdr.ubk.integration.tunduk.dto.grs.GrsAddressResponse;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.grs.GrsPassportResponse;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.msek.MsekDisabilityInfoResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDataResponse {
    private GrsPassportResponse passportData;
    private GrsAddressResponse addressData;
    private MsekDisabilityInfoResponse disabilityInfo;
    // etc. for other personal data
}
