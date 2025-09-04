package kg.gov.mtsdr.ubk.integration.tunduk.dto.msek;

import lombok.Data;
import java.io.Serializable;

@Data
public class AddressDto implements Serializable {
    private String region;
    private String district;
    private String city;
    private String street;
    private String house;
    private String apartment;
}
