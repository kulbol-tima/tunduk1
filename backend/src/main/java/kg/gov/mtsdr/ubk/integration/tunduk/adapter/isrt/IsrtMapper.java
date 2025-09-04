package kg.gov.mtsdr.ubk.integration.tunduk.adapter.isrt;

import kg.gov.mtsdr.ubk.integration.tunduk.dto.isrt.IsrtEmploymentStatusResponse;
import org.springframework.stereotype.Component;
import java.util.Collections;

@Component
public class IsrtMapper {

    public IsrtEmploymentStatusResponse toDto(Object rawResponse) {
        IsrtEmploymentStatusResponse response = new IsrtEmploymentStatusResponse();
        response.setData(Collections.singletonMap("placeholder", "Employment status data will be here."));
        return response;
    }
}
