package kg.gov.mtsdr.ubk.integration.tunduk.dto.gkdo;

import kg.gov.mtsdr.ubk.integration.tunduk.dto.response.TundukResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class GkdoChernobylResponse extends TundukResponse {
    private Map<String, Object> data;
}
