package kg.gov.mtsdr.ubk.integration.tunduk.dto.isrt;

import kg.gov.mtsdr.ubk.integration.tunduk.dto.response.TundukResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class IsrtEmploymentStatusResponse extends TundukResponse {
    /**
     * Placeholder for the actual employment status data structure.
     * This will be replaced with specific fields once the WSDL is available.
     */
    private Map<String, Object> data;
}
