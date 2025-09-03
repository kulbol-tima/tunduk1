package kg.gov.mtsdr.ubk.core.service;

import kg.gov.mtsdr.ubk.common.entity.IncomeData;
import kg.gov.mtsdr.ubk.web.dto.FamilyDataDto;
import kg.gov.mtsdr.ubk.web.dto.RegionDataDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BenefitCalculationServiceImpl implements BenefitCalculationService {

    private static final BigDecimal BASE_BENEFIT_PER_CHILD = new BigDecimal("1200");

    @Override
    public BigDecimal calculateBenefitAmount(FamilyDataDto familyData, RegionDataDto regionData) {
        // Formula: УБК = (1200 сом × кол-во детей × районный коэфф × доп коэфф) + надбавка
        log.info("Calculating benefit amount for family");
        // TODO: Implement full benefit calculation logic
        int numberOfChildren = familyData.getFamilyMembers().size(); // Placeholder
        BigDecimal benefit = BASE_BENEFIT_PER_CHILD.multiply(new BigDecimal(numberOfChildren))
                .multiply(regionData.getRegionCoefficient());
        return benefit; // Placeholder
    }

    @Override
    public BigDecimal applyRegionCoefficients(BigDecimal baseAmount, String regionCode) {
        log.info("Applying region coefficients for region: {}", regionCode);
        // TODO: Fetch coefficient from DB or config and apply
        return baseAmount.multiply(new BigDecimal("1.1")); // Placeholder
    }

    @Override
    public BigDecimal calculateSSDS(List<IncomeData> incomeData) {
        log.info("Calculating SSDS (среднедушевого дохода семьи)");
        // TODO: Implement SSDS calculation
        return BigDecimal.ZERO; // Placeholder
    }
}
