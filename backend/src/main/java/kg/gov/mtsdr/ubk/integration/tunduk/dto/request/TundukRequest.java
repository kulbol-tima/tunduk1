package kg.gov.mtsdr.ubk.integration.tunduk.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public abstract class TundukRequest implements Serializable {
    private final String requestId = UUID.randomUUID().toString();
    // Common request fields can be added here
}
