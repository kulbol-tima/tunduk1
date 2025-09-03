package kg.gov.mtsdr.ubk.web.dto;

import lombok.Data;
import java.util.List;

@Data
public class FamilyDataDto {
    private List<FamilyMemberDto> familyMembers;
    // ... other relevant family data
}
