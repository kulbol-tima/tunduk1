package kg.gov.mtsdr.ubk.core.service;

import kg.gov.mtsdr.ubk.core.repository.ApplicationRepository;
import kg.gov.mtsdr.ubk.web.dto.ApplicationDto;
import kg.gov.mtsdr.ubk.web.dto.FamilyDataDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Override
    public void submitApplication(ApplicationDto applicationDto) {
        log.info("Submitting application for PIN: {}", applicationDto.getApplicantPin());
        // TODO: Implement mapping from DTO to entity and save
    }

    @Override
    public void processApplication(Long id) {
        log.info("Processing application with ID: {}", id);
        // TODO: Implement application processing logic
    }

    @Override
    public boolean calculateEligibility(FamilyDataDto familyData) {
        log.info("Calculating eligibility for family");
        // TODO: Implement eligibility calculation logic
        return true; // Placeholder
    }

    @Override
    public boolean checkDuplicateApplications(String pin) {
        log.info("Checking for duplicate applications for PIN: {}", pin);
        return applicationRepository.findByApplicantPin(pin).isPresent();
    }
}
