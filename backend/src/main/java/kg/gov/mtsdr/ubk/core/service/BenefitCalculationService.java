package kg.gov.mtsdr.ubk.core.service;

import kg.gov.mtsdr.ubk.common.entity.IncomeData;
import kg.gov.mtsdr.ubk.web.dto.FamilyDataDto;
import kg.gov.mtsdr.ubk.web.dto.RegionDataDto;

import java.math.BigDecimal;
import java.util.List;

public interface BenefitCalculationService {

    BigDecimal calculateBenefitAmount(FamilyDataDto familyData, RegionDataDto regionData);

    BigDecimal applyRegionCoefficients(BigDecimal baseAmount, String regionCode);

    BigDecimal calculateSSDS(List<IncomeData> incomeData);
}
