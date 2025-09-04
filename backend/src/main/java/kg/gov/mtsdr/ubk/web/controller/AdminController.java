package kg.gov.mtsdr.ubk.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kg.gov.mtsdr.ubk.web.dto.admin.BaseValueUpdateRequest;
import kg.gov.mtsdr.ubk.web.dto.admin.CoefficientUpdateRequest;
import kg.gov.mtsdr.ubk.web.dto.admin.IntegrationLogResponse;
import kg.gov.mtsdr.ubk.web.dto.admin.SystemStatusResponse;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/admin")
@Tag(name = "Admin API", description = "API for administrative tasks")
@SecurityRequirement(name = "bearerAuth")
public class AdminController {

    @PutMapping("/coefficients")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update benefit calculation coefficients")
    public ResponseEntity<Void> updateCoefficients(@Valid @RequestBody CoefficientUpdateRequest request) {
        // Placeholder logic
        return ResponseEntity.ok().build();
    }

    @PostMapping("/recalculation/base-value")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update the base value for recalculations")
    public ResponseEntity<Void> updateBaseValue(@Valid @RequestBody BaseValueUpdateRequest request) {
        // Placeholder logic
        return ResponseEntity.ok().build();
    }

    @GetMapping("/system-status")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Get the health status of the system and its integrations")
    public ResponseEntity<SystemStatusResponse> getSystemStatus() {
        // Placeholder logic
        return ResponseEntity.ok(SystemStatusResponse.builder().databaseStatus("OK").build());
    }

    @GetMapping("/integration-logs")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Get a paginated list of Tunduk integration logs")
    public ResponseEntity<Page<IntegrationLogResponse>> getIntegrationLogs(@ParameterObject @PageableDefault(size = 50) Pageable pageable) {
        // Placeholder logic
        return ResponseEntity.ok(new PageImpl<>(Collections.emptyList(), pageable, 0));
    }
}
