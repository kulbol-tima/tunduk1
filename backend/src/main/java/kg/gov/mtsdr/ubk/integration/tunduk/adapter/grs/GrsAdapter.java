package kg.gov.mtsdr.ubk.integration.tunduk.adapter.grs;

import kg.gov.mtsdr.ubk.integration.tunduk.client.XRoadClient;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.grs.*;
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
public class GrsAdapter {

    private final XRoadClient xRoadClient;
    private final GrsMapper grsMapper;

    @Cacheable(cacheNames = "tunduk-grs-passport", key = "#pin")
    @Retryable(value = {WebServiceIOException.class}, maxAttempts = 3, backoff = @Backoff(delay = 2000))
    public GrsPassportResponse getPersonData(String pin) {
        log.info("Fetching GRS passport data for PIN: {}", pin);
        Object soapResponse = xRoadClient.callService(new GrsPersonDataRequest(pin), "grs-passport");
        return grsMapper.toPassportDto(soapResponse);
    }

    @Cacheable(cacheNames = "tunduk-grs-zags", key = "#pin")
    @Retryable(value = {WebServiceIOException.class}, maxAttempts = 3, backoff = @Backoff(delay = 2000))
    public GrsZagsResponse getZagsData(String pin) {
        log.info("Fetching GRS ZAGS data for PIN: {}", pin);
        Object soapResponse = xRoadClient.callService(new GrsPersonDataRequest(pin), "grs-zags");
        return grsMapper.toZagsDto(soapResponse);
    }

    @Cacheable(cacheNames = "tunduk-grs-address", key = "#pin")
    @Retryable(value = {WebServiceIOException.class}, maxAttempts = 3, backoff = @Backoff(delay = 2000))
    public GrsAddressResponse getActualAddress(String pin) {
        log.info("Fetching GRS actual address for PIN: {}", pin);
        Object soapResponse = xRoadClient.callService(new GrsPersonDataRequest(pin), "grs-address");
        return grsMapper.toAddressDto(soapResponse);
    }

    @Cacheable(cacheNames = "tunduk-grs-vehicle", key = "#pin")
    @Retryable(value = {WebServiceIOException.class}, maxAttempts = 3, backoff = @Backoff(delay = 2000))
    public GrsVehicleResponse getVehicleInfo(String pin) {
        log.info("Fetching GRS vehicle info for PIN: {}", pin);
        Object soapResponse = xRoadClient.callService(new GrsPersonDataRequest(pin), "grs-vehicle");
        return grsMapper.toVehicleDto(soapResponse);
    }
}
