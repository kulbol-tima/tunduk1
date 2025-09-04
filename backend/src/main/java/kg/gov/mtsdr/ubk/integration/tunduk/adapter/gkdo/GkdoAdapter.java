package kg.gov.mtsdr.ubk.integration.tunduk.adapter.gkdo;

import kg.gov.mtsdr.ubk.integration.tunduk.client.XRoadClient;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.gkdo.*;
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
public class GkdoAdapter {

    private final XRoadClient xRoadClient;
    private final GkdoMapper gkdoMapper;

    @Cacheable(cacheNames = "tunduk-gkdo-war-veteran", key = "#pin")
    @Retryable(value = {WebServiceIOException.class}, maxAttempts = 3, backoff = @Backoff(delay = 2000))
    public GkdoWarVeteranResponse getWarVeteranInfo(String pin) {
        log.info("Fetching GKDO War Veteran info for PIN: {}", pin);
        Object soapResponse = xRoadClient.callService(new GkdoRequest(pin), "gkdo-wwii");
        return gkdoMapper.toWarVeteranDto(soapResponse);
    }

    @Cacheable(cacheNames = "tunduk-gkdo-war-death", key = "#pin")
    @Retryable(value = {WebServiceIOException.class}, maxAttempts = 3, backoff = @Backoff(delay = 2000))
    public GkdoWarDeathResponse getWarDeathInfo(String pin) {
        log.info("Fetching GKDO War Death info for PIN: {}", pin);
        Object soapResponse = xRoadClient.callService(new GkdoRequest(pin), "gkdo-war-death");
        return gkdoMapper.toWarDeathDto(soapResponse);
    }

    @Cacheable(cacheNames = "tunduk-gkdo-chernobyl", key = "#pin")
    @Retryable(value = {WebServiceIOException.class}, maxAttempts = 3, backoff = @Backoff(delay = 2000))
    public GkdoChernobylResponse getChernobylInfo(String pin) {
        log.info("Fetching GKDO Chernobyl info for PIN: {}", pin);
        Object soapResponse = xRoadClient.callService(new GkdoRequest(pin), "gkdo-chernobyl");
        return gkdoMapper.toChernobylDto(soapResponse);
    }

    @Cacheable(cacheNames = "tunduk-gkdo-chernobyl-death", key = "#pin")
    @Retryable(value = {WebServiceIOException.class}, maxAttempts = 3, backoff = @Backoff(delay = 2000))
    public GkdoChernobylDeathResponse getChernobylDeathInfo(String pin) {
        log.info("Fetching GKDO Chernobyl Death info for PIN: {}", pin);
        Object soapResponse = xRoadClient.callService(new GkdoRequest(pin), "gkdo-chernobyl-death");
        return gkdoMapper.toChernobylDeathDto(soapResponse);
    }

    @Cacheable(cacheNames = "tunduk-gkdo-afghan-veteran", key = "#pin")
    @Retryable(value = {WebServiceIOException.class}, maxAttempts = 3, backoff = @Backoff(delay = 2000))
    public GkdoAfghanVeteranResponse getAfghanVeteranInfo(String pin) {
        log.info("Fetching GKDO Afghan Veteran info for PIN: {}", pin);
        Object soapResponse = xRoadClient.callService(new GkdoRequest(pin), "gkdo-afghan");
        return gkdoMapper.toAfghanVeteranDto(soapResponse);
    }
}
