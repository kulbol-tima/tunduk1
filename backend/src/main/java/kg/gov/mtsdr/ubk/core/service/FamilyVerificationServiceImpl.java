package kg.gov.mtsdr.ubk.core.service;

import kg.gov.mtsdr.ubk.common.entity.Application;
import kg.gov.mtsdr.ubk.common.entity.FamilyMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class FamilyVerificationServiceImpl implements FamilyVerificationService {

    @Override
    public void verifyFamilyComposition(Application application) {
        log.info("Verifying family composition for application ID: {}", application.getId());
        // TODO: Implement verification logic against external systems (e.g., Tunduk)
    }

    @Override
    public boolean validateFamilyData(List<FamilyMember> familyMembers) {
        log.info("Validating data for {} family members", familyMembers.size());
        // TODO: Implement validation rules for family member data
        return true; // Placeholder
    }

    @Override
    public boolean checkChildrenAges(List<FamilyMember> familyMembers) {
        log.info("Checking ages of children for {} family members", familyMembers.size());
        final int MAX_CHILD_AGE = 16;
        // TODO: Refine this logic based on actual requirements
        return familyMembers.stream()
                .allMatch(member -> Period.between(member.getBirthDate(), LocalDate.now()).getYears() < MAX_CHILD_AGE);
    }
}
