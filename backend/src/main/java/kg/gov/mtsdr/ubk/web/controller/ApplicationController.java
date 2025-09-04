package kg.gov.mtsdr.ubk.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kg.gov.mtsdr.ubk.web.dto.application.*;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/applications")
@Tag(name = "Application API", description = "API for managing social benefit applications")
public class ApplicationController {

    @PostMapping
    @Operation(summary = "Submit a new application")
    public ResponseEntity<ApplicationResponse> submitApplication(@Valid @RequestBody NewApplicationRequest request) {
        // Placeholder logic
        return ResponseEntity.ok(new ApplicationResponse());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an application by its ID")
    public ResponseEntity<ApplicationResponse> getApplicationById(@PathVariable Long id) {
        // Placeholder logic
        return ResponseEntity.ok(new ApplicationResponse());
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "Update the status of an application")
    public ResponseEntity<ApplicationResponse> updateApplicationStatus(@PathVariable Long id, @Valid @RequestBody ApplicationStatusUpdateRequest request) {
        // Placeholder logic
        return ResponseEntity.ok(new ApplicationResponse());
    }

    @GetMapping("/search")
    @Operation(summary = "Search for applications with pagination")
    public ResponseEntity<Page<ApplicationResponse>> searchApplications(
            @ParameterObject @Valid ApplicationSearchRequest request,
            @ParameterObject @PageableDefault(size = 20) Pageable pageable) {
        // Placeholder logic
        return ResponseEntity.ok(new PageImpl<>(Collections.emptyList(), pageable, 0));
    }

    @PostMapping("/validate")
    @Operation(summary = "Validate application data before submission")
    public ResponseEntity<Void> validateApplicationData(@Valid @RequestBody ApplicationValidationRequest request) {
        // Placeholder logic: if validation passes, return 200 OK.
        // The @Valid annotation will trigger a 400 Bad Request if it fails.
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/family-verification")
    @Operation(summary = "Get the family verification status for an application")
    public ResponseEntity<FamilyVerificationResponse> getFamilyVerificationStatus(@PathVariable Long id) {
        // Placeholder logic
        return ResponseEntity.ok(FamilyVerificationResponse.builder().build());
    }
}
