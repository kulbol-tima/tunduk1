package kg.gov.mtsdr.ubk.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.gov.mtsdr.ubk.web.dto.report.FilteredReportRequest;
import kg.gov.mtsdr.ubk.web.dto.report.MonthlyReportResponse;
import kg.gov.mtsdr.ubk.web.dto.report.PaymentsReportResponse;
import kg.gov.mtsdr.ubk.web.dto.report.StatisticsReportResponse;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/reports")
@Tag(name = "Report API", description = "API for generating reports")
public class ReportController {

    @GetMapping("/monthly")
    @Operation(summary = "Get a monthly report")
    public ResponseEntity<MonthlyReportResponse> getMonthlyReport() {
        // Placeholder logic
        return ResponseEntity.ok(MonthlyReportResponse.builder().build());
    }

    @GetMapping("/payments")
    @Operation(summary = "Get a detailed report on payments")
    public ResponseEntity<PaymentsReportResponse> getPaymentsReport() {
        // Placeholder logic
        return ResponseEntity.ok(PaymentsReportResponse.builder()
                .payments(new PageImpl<>(Collections.emptyList()))
                .build());
    }

    @GetMapping("/statistics")
    @Operation(summary = "Get general statistics")
    public ResponseEntity<StatisticsReportResponse> getStatistics() {
        // Placeholder logic
        return ResponseEntity.ok(StatisticsReportResponse.builder().build());
    }

    @GetMapping("/filter")
    @Operation(summary = "Get a report based on specific filters")
    public ResponseEntity<Void> getFilteredReport(@ParameterObject FilteredReportRequest request) {
        // Placeholder logic
        // This would likely return a pageable list of recipients or applications
        return ResponseEntity.ok().build();
    }
}
