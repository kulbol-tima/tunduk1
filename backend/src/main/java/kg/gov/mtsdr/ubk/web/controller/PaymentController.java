package kg.gov.mtsdr.ubk.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kg.gov.mtsdr.ubk.web.dto.payment.BankTransferResponse;
import kg.gov.mtsdr.ubk.web.dto.payment.PaymentGenerationRequest;
import kg.gov.mtsdr.ubk.web.dto.payment.PaymentReportResponse;
import kg.gov.mtsdr.ubk.web.dto.payment.PaymentResponse;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/payments")
@Tag(name = "Payment API", description = "API for managing benefit payments")
public class PaymentController {

    @GetMapping
    @Operation(summary = "Get a paginated list of payments")
    public ResponseEntity<Page<PaymentResponse>> getAllPayments(@ParameterObject @PageableDefault(size = 20) Pageable pageable) {
        // Placeholder logic
        return ResponseEntity.ok(new PageImpl<>(Collections.emptyList(), pageable, 0));
    }

    @PostMapping("/generate")
    @Operation(summary = "Generate a new batch of payments for a period")
    public ResponseEntity<Void> generatePayments(@Valid @RequestBody PaymentGenerationRequest request) {
        // Placeholder logic
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/reports")
    @Operation(summary = "Get a summary report of payments")
    public ResponseEntity<PaymentReportResponse> getPaymentReport() {
        // Placeholder logic
        return ResponseEntity.ok(PaymentReportResponse.builder().build());
    }

    @PostMapping("/bank-transfer")
    @Operation(summary = "Send a payment batch to the bank")
    public ResponseEntity<BankTransferResponse> sendToBank() {
        // Placeholder logic
        return ResponseEntity.ok(BankTransferResponse.builder().status("SENT").build());
    }

    @GetMapping("/status/{paymentId}")
    @Operation(summary = "Get the status of a specific payment")
    public ResponseEntity<PaymentResponse> getPaymentStatus(@PathVariable Long paymentId) {
        // Placeholder logic
        return ResponseEntity.ok(new PaymentResponse());
    }
}
