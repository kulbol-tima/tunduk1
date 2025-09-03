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

@Entity
@Table(name = "income_data")
@Getter
@Setter
public class IncomeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_member_id", nullable = false)
    @JsonBackReference
    private FamilyMember familyMember;

    @NotBlank
    @Size(max = 100)
    @Column(name = "income_type", nullable = false)
    private String incomeType;

    @NotNull
    @PositiveOrZero
    @Column(name = "amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @NotBlank
    @Size(max = 50)
    @Column(name = "period", nullable = false)
    private String period;

    @Size(max = 255)
    @Column(name = "occupation")
    private String occupation;

    @PositiveOrZero
    @Column(name = "education_expenses", precision = 12, scale = 2)
    private BigDecimal educationExpenses;

    @Size(max = 255)
    @Column(name = "business_activity")
    private String businessActivity;

    @PositiveOrZero
    @Column(name = "land_area", precision = 10, scale = 4)
    private BigDecimal landArea;

    @Column(name = "livestock")
    private String livestock;

    @PositiveOrZero
    @Column(name = "bank_deposits", precision = 12, scale = 2)
    private BigDecimal bankDeposits;
}
