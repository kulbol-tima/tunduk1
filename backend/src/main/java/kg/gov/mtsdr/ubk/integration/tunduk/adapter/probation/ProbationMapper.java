package kg.gov.mtsdr.ubk.integration.tunduk.adapter.probation;

import kg.gov.mtsdr.ubk.integration.tunduk.dto.probation.ProbationClientInfoResponse;
import org.springframework.stereotype.Component;
import java.util.Collections;

@Component
public class ProbationMapper {

    public ProbationClientInfoResponse toDto(Object rawResponse) {
        ProbationClientInfoResponse response = new ProbationClientInfoResponse();
        response.setData(Collections.singletonMap("placeholder", "Probation client data will be here."));
        return response;
    }
}
