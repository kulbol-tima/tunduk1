package kg.gov.mtsdr.ubk.common.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipient_id", nullable = false)
    @JsonBackReference
    private Recipient recipient;

    @NotNull
    @Positive
    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @NotNull
    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @NotBlank
    @Size(max = 100)
    @Column(name = "bank_account", nullable = false)
    private String bankAccount;

    @NotBlank
    @Size(max = 50)
    @Column(name = "status", nullable = false)
    private String status;
}
