package kg.gov.mtsdr.ubk.core.repository;

import kg.gov.mtsdr.ubk.common.entity.IncomeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeDataRepository extends JpaRepository<IncomeData, Long> {

    List<IncomeData> findByFamilyMemberId(Long familyMemberId);

    List<IncomeData> findByFamilyMemberIdAndIncomeType(Long familyMemberId, String incomeType);
}
