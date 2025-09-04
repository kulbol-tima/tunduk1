package kg.gov.mtsdr.ubk.integration.tunduk.adapter.kissp;

import kg.gov.mtsdr.ubk.integration.tunduk.dto.kissp.KisspAvailableServicesResponse;
import org.springframework.stereotype.Component;
import java.util.Collections;

@Component
public class KisspMapper {

    public KisspAvailableServicesResponse toDto(Object rawResponse) {
        KisspAvailableServicesResponse response = new KisspAvailableServicesResponse();
        response.setData(Collections.singletonMap("placeholder", "Available services data will be here."));
        return response;
    }
}
