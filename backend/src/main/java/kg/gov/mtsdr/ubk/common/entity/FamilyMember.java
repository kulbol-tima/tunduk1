package kg.gov.mtsdr.ubk.common.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "family_members")
@Getter
@Setter
public class FamilyMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_id", nullable = false)
    @JsonBackReference // To prevent infinite recursion in JSON serialization
    private Application application;

    @NotBlank
    @Size(max = 255)
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @NotBlank
    @Size(max = 10)
    @Column(name = "gender", nullable = false)
    private String gender;

    @NotNull
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @NotBlank
    @Size(min = 14, max = 14)
    @Column(name = "pin", unique = true, nullable = false, length = 14)
    private String pin;

    @Size(max = 50)
    @Column(name = "passport")
    private String passport;

    @NotBlank
    @Size(max = 50)
    @Column(name = "relationship", nullable = false)
    private String relationship;

    @NotBlank
    @Size(max = 100)
    @Column(name = "citizenship", nullable = false)
    private String citizenship;

    // --- Relationships ---
    @OneToMany(mappedBy = "familyMember", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IncomeData> incomeData;
}
