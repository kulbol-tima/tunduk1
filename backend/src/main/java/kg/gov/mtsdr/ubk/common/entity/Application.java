package kg.gov.mtsdr.ubk.common.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "applications")
@Getter
@Setter
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "registration_number", unique = true, nullable = false)
    private String registrationNumber;

    @NotNull
    @Column(name = "application_date", nullable = false)
    private LocalDate applicationDate;

    @NotBlank
    @Size(max = 255)
    @Column(name = "applicant_full_name", nullable = false)
    private String applicantFullName;

    @NotBlank
    @Size(min = 14, max = 14)
    @Column(name = "applicant_pin", unique = true, nullable = false, length = 14)
    private String applicantPin;

    @NotBlank
    @Size(max = 255)
    @Column(name = "address", nullable = false)
    private String address;

    @NotBlank
    @Size(max = 20)
    @Column(name = "phone", nullable = false)
    private String phone;

    @NotBlank
    @Size(max = 10)
    @Column(name = "passport_series", nullable = false)
    private String passportSeries;

    @NotBlank
    @Size(max = 20)
    @Column(name = "passport_number", nullable = false)
    private String passportNumber;

    @NotBlank
    @Size(max = 50)
    @Column(name = "family_status", nullable = false)
    private String familyStatus;

    @Column(name = "previous_benefit")
    private Boolean previousBenefit;

    @NotBlank
    @Size(max = 50)
    @Column(name = "status", nullable = false)
    private String status;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // --- Relationships ---
    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FamilyMember> familyMembers;

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recipient> recipients;
}
