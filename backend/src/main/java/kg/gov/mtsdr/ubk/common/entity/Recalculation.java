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

@Entity
@Table(name = "recalculations")
@Getter
@Setter
public class Recalculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipient_id", nullable = false)
    @JsonBackReference
    private Recipient recipient;

    @NotBlank
    @Size(max = 100)
    @Column(name = "recalculation_type", nullable = false)
    private String recalculationType;

    @NotNull
    @PositiveOrZero
    @Column(name = "old_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal oldAmount;

    @NotNull
    @PositiveOrZero
    @Column(name = "new_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal newAmount;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotBlank
    @Size(max = 50)
    @Column(name = "status", nullable = false)
    private String status;

    @Size(max = 255)
    @Column(name = "source_event")
    private String sourceEvent;
}
