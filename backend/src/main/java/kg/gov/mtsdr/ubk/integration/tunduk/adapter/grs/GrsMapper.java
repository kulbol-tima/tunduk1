package kg.gov.mtsdr.ubk.integration.tunduk.adapter.grs;

import kg.gov.mtsdr.ubk.integration.tunduk.dto.grs.GrsAddressResponse;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.grs.GrsPassportResponse;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.grs.GrsVehicleResponse;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.grs.GrsZagsResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class GrsMapper {

    public GrsPassportResponse toPassportDto(Object rawResponse) {
        GrsPassportResponse response = new GrsPassportResponse();
        response.setData(Collections.singletonMap("placeholder", "Passport data will be here."));
        return response;
    }

    public GrsZagsResponse toZagsDto(Object rawResponse) {
        GrsZagsResponse response = new GrsZagsResponse();
        response.setData(Collections.singletonMap("placeholder", "ZAGS data will be here."));
        return response;
    }

    public GrsAddressResponse toAddressDto(Object rawResponse) {
        GrsAddressResponse response = new GrsAddressResponse();
        response.setData(Collections.singletonMap("placeholder", "Address data will be here."));
        return response;
    }

    public GrsVehicleResponse toVehicleDto(Object rawResponse) {
        GrsVehicleResponse response = new GrsVehicleResponse();
        response.setData(Collections.singletonMap("placeholder", "Vehicle data will be here."));
        return response;
    }
}
