package kg.gov.mtsdr.ubk.integration.tunduk.adapter.sf;

import kg.gov.mtsdr.ubk.integration.tunduk.dto.sf.SfPensionStatusResponse;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.sf.SfWorkPeriodsResponse;
import org.springframework.stereotype.Component;
import java.util.Collections;

@Component
public class SfMapper {

    public SfPensionStatusResponse toPensionStatusDto(Object rawResponse) {
        SfPensionStatusResponse response = new SfPensionStatusResponse();
        response.setData(Collections.singletonMap("placeholder", "Pension status data will be here."));
        return response;
    }

    public SfWorkPeriodsResponse toWorkPeriodsDto(Object rawResponse) {
        SfWorkPeriodsResponse response = new SfWorkPeriodsResponse();
        response.setData(Collections.singletonMap("placeholder", "Work periods data will be here."));
        return response;
    }
}
