package kg.gov.mtsdr.ubk.web.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ApplicationDto {
    private String applicantFullName;
    private String applicantPin;
    private String address;
    private String phone;
    // ... other fields as needed
}
