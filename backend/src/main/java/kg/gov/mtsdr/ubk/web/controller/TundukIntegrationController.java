package kg.gov.mtsdr.ubk.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.gov.mtsdr.ubk.integration.tunduk.adapter.grs.GrsAdapter;
import kg.gov.mtsdr.ubk.integration.tunduk.adapter.msek.MsekAdapter;
import kg.gov.mtsdr.ubk.integration.tunduk.adapter.sf.SfAdapter;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.grs.GrsZagsResponse;
import kg.gov.mtsdr.ubk.web.dto.integration.IncomeDataResponse;
import kg.gov.mtsdr.ubk.web.dto.integration.PersonDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/integration")
@Tag(name = "Tunduk Integration API", description = "API for fetching data from government services via Tunduk")
@RequiredArgsConstructor
public class TundukIntegrationController {

    private final GrsAdapter grsAdapter;
    private final MsekAdapter msekAdapter;
    private final SfAdapter sfAdapter;
    // Inject other adapters as needed, e.g., GnsAdapter

    @GetMapping("/person-data/{pin}")
    @Operation(summary = "Get aggregated personal data for a given PIN")
    public ResponseEntity<PersonDataResponse> getPersonData(@PathVariable String pin) {
        // In a real implementation, you might run these calls in parallel
        PersonDataResponse response = PersonDataResponse.builder()
                .passportData(grsAdapter.getPersonData(pin))
                .addressData(grsAdapter.getActualAddress(pin))
                .disabilityInfo(msekAdapter.getDisabilityInfo(pin))
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/income-data/{pin}")
    @Operation(summary = "Get aggregated income data for a given PIN")
    public ResponseEntity<IncomeDataResponse> getIncomeData(@PathVariable String pin) {
        IncomeDataResponse response = IncomeDataResponse.builder()
                .pensionStatus(sfAdapter.getPensionStatus(pin))
                .workPeriods(sfAdapter.getWorkPeriods(pin))
                // .patentInfo(gnsAdapter.getPatentInfo(pin)) // Uncomment when GNS is available
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/family-data/{pin}")
    @Operation(summary = "Get family data (from ZAGS) for a given PIN")
    public ResponseEntity<GrsZagsResponse> getFamilyData(@PathVariable String pin) {
        GrsZagsResponse response = grsAdapter.getZagsData(pin);
        return ResponseEntity.ok(response);
    }
}
