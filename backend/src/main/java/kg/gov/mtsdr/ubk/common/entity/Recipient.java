package kg.gov.mtsdr.ubk.common.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "recipients")
@Getter
@Setter
public class Recipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_id", nullable = false)
    @JsonBackReference
    private Application application;

    @NotNull
    @PositiveOrZero
    @Column(name = "benefit_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal benefitAmount;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "region_coefficient", precision = 5, scale = 2)
    private BigDecimal regionCoefficient;

    @Column(name = "additional_coefficient", precision = 5, scale = 2)
    private BigDecimal additionalCoefficient;

    @Column(name = "bonus", precision = 10, scale = 2)
    private BigDecimal bonus;

    @NotBlank
    @Size(max = 50)
    @Column(name = "status", nullable = false)
    private String status;

    // --- Relationships ---
    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments;

    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recalculation> recalculations;
}
