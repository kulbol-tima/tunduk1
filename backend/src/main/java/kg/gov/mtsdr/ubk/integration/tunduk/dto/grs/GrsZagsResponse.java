package kg.gov.mtsdr.ubk.integration.tunduk.dto.grs;

import kg.gov.mtsdr.ubk.integration.tunduk.dto.response.TundukResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class GrsZagsResponse extends TundukResponse {
    /**
     * Placeholder for the actual civil registry (ZAGS) data structure.
     * This will be replaced with specific fields once the WSDL is available.
     */
    private Map<String, Object> data;
}
