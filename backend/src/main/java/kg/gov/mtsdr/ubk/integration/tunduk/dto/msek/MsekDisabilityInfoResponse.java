package kg.gov.mtsdr.ubk.integration.tunduk.dto.msek;

import kg.gov.mtsdr.ubk.integration.tunduk.dto.response.TundukResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class MsekDisabilityInfoResponse extends TundukResponse {
    private String pin;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate birthDate;
    private int gender;
    private String nationality;
    private int disabilityGroup;
    private String disabilityCause;
    private LocalDate disabilityDate;
    private LocalDate disabilityTerm;
    private LocalDate nextCheckDate;
    private String workRecommendation;
    private boolean isWorking;
    private AddressDto address;
    private DocumentDto document;
}
