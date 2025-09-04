package kg.gov.mtsdr.ubk.integration.tunduk.adapter.vet;

import kg.gov.mtsdr.ubk.integration.tunduk.dto.vet.VetLivestockResponse;
import org.springframework.stereotype.Component;
import java.util.Collections;

@Component
public class VetMapper {

    public VetLivestockResponse toDto(Object rawResponse) {
        VetLivestockResponse response = new VetLivestockResponse();
        response.setData(Collections.singletonMap("placeholder", "Livestock data will be here."));
        return response;
    }
}
