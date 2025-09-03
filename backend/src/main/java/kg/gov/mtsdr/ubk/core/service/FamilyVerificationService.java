package kg.gov.mtsdr.ubk.core.service;

import kg.gov.mtsdr.ubk.common.entity.Application;
import kg.gov.mtsdr.ubk.common.entity.FamilyMember;

import java.util.List;

public interface FamilyVerificationService {

    void verifyFamilyComposition(Application application);

    boolean validateFamilyData(List<FamilyMember> familyMembers);

    boolean checkChildrenAges(List<FamilyMember> familyMembers);
}
