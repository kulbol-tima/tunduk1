package kg.gov.mtsdr.ubk.core.repository;

import kg.gov.mtsdr.ubk.common.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Optional<Application> findByRegistrationNumber(String registrationNumber);

    Optional<Application> findByApplicantPin(String applicantPin);

    List<Application> findByStatus(String status);

    List<Application> findByApplicationDateBetween(LocalDate startDate, LocalDate endDate);
}
