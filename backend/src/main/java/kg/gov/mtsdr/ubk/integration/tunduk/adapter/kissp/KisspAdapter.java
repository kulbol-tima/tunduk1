package kg.gov.mtsdr.ubk.integration.tunduk.adapter.kissp;

import kg.gov.mtsdr.ubk.integration.tunduk.adapter.TundukAdapter;
import kg.gov.mtsdr.ubk.integration.tunduk.client.XRoadClient;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.kissp.KisspAvailableServicesResponse;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.kissp.KisspRequest;
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
public class KisspAdapter extends TundukAdapter<KisspRequest, KisspAvailableServicesResponse> {

    private final XRoadClient xRoadClient;
    private final KisspMapper kisspMapper;
    private static final String SERVICE_NAME = "kissp-services";

    @Override
    public KisspAvailableServicesResponse call(KisspRequest request) {
        return getAvailableServices(request.getPin());
    }

    @Override
    public String getServiceName() {
        return SERVICE_NAME;
    }

    @Cacheable(cacheNames = "tunduk-kissp-services", key = "#pin")
    @Retryable(
            value = {WebServiceIOException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000)
    )
    public KisspAvailableServicesResponse getAvailableServices(String pin) {
        log.info("Fetching available services from KISSP for PIN: {}", pin);
        Object soapRequest = new KisspRequest(pin);
        Object soapResponse = xRoadClient.callService(soapRequest, SERVICE_NAME);
        return kisspMapper.toDto(soapResponse);
    }
}
