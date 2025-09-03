package kg.gov.mtsdr.ubk.core.repository;

import kg.gov.mtsdr.ubk.common.entity.Recalculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RecalculationRepository extends JpaRepository<Recalculation, Long> {

    List<Recalculation> findByRecipientId(Long recipientId);

    List<Recalculation> findByStatus(String status);

    List<Recalculation> findByStartDateBetween(LocalDate startDate, LocalDate endDate);
}
