package kg.gov.mtsdr.ubk.integration.tunduk.adapter.sf;

import kg.gov.mtsdr.ubk.integration.tunduk.client.XRoadClient;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.sf.SfPensionStatusResponse;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.sf.SfRequest;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.sf.SfWorkPeriodsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.WebServiceIOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class SfAdapter {

    private final XRoadClient xRoadClient;
    private final SfMapper sfMapper;

    @Cacheable(cacheNames = "tunduk-sf-pension", key = "#pin")
    @Retryable(value = {WebServiceIOException.class}, maxAttempts = 3, backoff = @Backoff(delay = 2000))
    public SfPensionStatusResponse getPensionStatus(String pin) {
        log.info("Fetching pension status from SF for PIN: {}", pin);
        Object soapResponse = xRoadClient.callService(new SfRequest(pin), "sf-pension");
        return sfMapper.toPensionStatusDto(soapResponse);
    }

    @Cacheable(cacheNames = "tunduk-sf-work-history", key = "#pin")
    @Retryable(value = {WebServiceIOException.class}, maxAttempts = 3, backoff = @Backoff(delay = 2000))
    public SfWorkPeriodsResponse getWorkPeriods(String pin) {
        log.info("Fetching work periods from SF for PIN: {}", pin);
        Object soapResponse = xRoadClient.callService(new SfRequest(pin), "sf-work-history");
        return sfMapper.toWorkPeriodsDto(soapResponse);
    }
}
