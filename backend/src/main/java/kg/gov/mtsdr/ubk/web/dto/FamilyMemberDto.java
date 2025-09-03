package kg.gov.mtsdr.ubk.web.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class FamilyMemberDto {
    private String fullName;
    private String pin;
    private LocalDate birthDate;
}
