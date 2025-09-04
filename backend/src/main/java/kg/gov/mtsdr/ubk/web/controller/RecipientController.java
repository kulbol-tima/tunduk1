package kg.gov.mtsdr.ubk.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.gov.mtsdr.ubk.web.dto.recipient.EligibilityCheckResponse;
import kg.gov.mtsdr.ubk.web.dto.recipient.RecipientListItem;
import kg.gov.mtsdr.ubk.web.dto.recipient.RecipientResponse;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/recipients")
@Tag(name = "Recipient API", description = "API for managing benefit recipients")
public class RecipientController {

    @GetMapping
    @Operation(summary = "Get a paginated list of recipients")
    public ResponseEntity<Page<RecipientListItem>> getAllRecipients(@ParameterObject @PageableDefault(size = 20) Pageable pageable) {
        // Placeholder logic
        return ResponseEntity.ok(new PageImpl<>(Collections.emptyList(), pageable, 0));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get detailed information about a single recipient")
    public ResponseEntity<RecipientResponse> getRecipientById(@PathVariable Long id) {
        // Placeholder logic
        return ResponseEntity.ok(new RecipientResponse());
    }

    @PutMapping("/{id}/recalculate")
    @Operation(summary = "Trigger a benefit recalculation for a recipient")
    public ResponseEntity<RecipientResponse> recalculateBenefit(@PathVariable Long id) {
        // Placeholder logic
        return ResponseEntity.ok(new RecipientResponse());
    }

    @GetMapping("/by-region/{regionCode}")
    @Operation(summary = "Get a paginated list of recipients by region code")
    public ResponseEntity<Page<RecipientListItem>> getRecipientsByRegion(
            @PathVariable String regionCode,
            @ParameterObject @PageableDefault(size = 20) Pageable pageable) {
        // Placeholder logic
        return ResponseEntity.ok(new PageImpl<>(Collections.emptyList(), pageable, 0));
    }

    @GetMapping("/eligibility-check/{pin}")
    @Operation(summary = "Check if a person is eligible for benefits by their PIN")
    public ResponseEntity<EligibilityCheckResponse> checkEligibility(@PathVariable String pin) {
        // Placeholder logic
        return ResponseEntity.ok(EligibilityCheckResponse.builder().isEligible(true).build());
    }
}
