package kg.gov.mtsdr.ubk.core.service;

import kg.gov.mtsdr.ubk.web.dto.ApplicationDto;
import kg.gov.mtsdr.ubk.web.dto.FamilyDataDto;

public interface ApplicationService {

    void submitApplication(ApplicationDto applicationDto);

    void processApplication(Long id);

    boolean calculateEligibility(FamilyDataDto familyData);

    boolean checkDuplicateApplications(String pin);
}
