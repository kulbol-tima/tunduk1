package kg.gov.mtsdr.ubk.integration.tunduk.adapter.gkdo;

import kg.gov.mtsdr.ubk.integration.tunduk.dto.gkdo.*;
import org.springframework.stereotype.Component;
import java.util.Collections;

@Component
public class GkdoMapper {

    public GkdoWarVeteranResponse toWarVeteranDto(Object rawResponse) {
        GkdoWarVeteranResponse response = new GkdoWarVeteranResponse();
        response.setData(Collections.singletonMap("placeholder", "War veteran data will be here."));
        return response;
    }

    public GkdoWarDeathResponse toWarDeathDto(Object rawResponse) {
        GkdoWarDeathResponse response = new GkdoWarDeathResponse();
        response.setData(Collections.singletonMap("placeholder", "War death data will be here."));
        return response;
    }

    public GkdoChernobylResponse toChernobylDto(Object rawResponse) {
        GkdoChernobylResponse response = new GkdoChernobylResponse();
        response.setData(Collections.singletonMap("placeholder", "Chernobyl veteran data will be here."));
        return response;
    }

    public GkdoChernobylDeathResponse toChernobylDeathDto(Object rawResponse) {
        GkdoChernobylDeathResponse response = new GkdoChernobylDeathResponse();
        response.setData(Collections.singletonMap("placeholder", "Chernobyl death data will be here."));
        return response;
    }

    public GkdoAfghanVeteranResponse toAfghanVeteranDto(Object rawResponse) {
        GkdoAfghanVeteranResponse response = new GkdoAfghanVeteranResponse();
        response.setData(Collections.singletonMap("placeholder", "Afghan veteran data will be here."));
        return response;
    }
}
