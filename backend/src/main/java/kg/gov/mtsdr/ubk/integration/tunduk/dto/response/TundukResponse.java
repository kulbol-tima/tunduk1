package kg.gov.mtsdr.ubk.integration.tunduk.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class TundukResponse implements Serializable {
    private String originalRequestId;
    // Common response fields can be added here
}
