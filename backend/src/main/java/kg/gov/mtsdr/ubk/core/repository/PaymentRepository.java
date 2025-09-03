package kg.gov.mtsdr.ubk.core.repository;

import kg.gov.mtsdr.ubk.common.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByRecipientId(Long recipientId);

    List<Payment> findByStatus(String status);

    List<Payment> findByPaymentDateBetween(LocalDate startDate, LocalDate endDate);
}
