package kg.gov.mtsdr.ubk.integration.tunduk.adapter.vet;

import kg.gov.mtsdr.ubk.integration.tunduk.adapter.TundukAdapter;
import kg.gov.mtsdr.ubk.integration.tunduk.client.XRoadClient;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.vet.VetLivestockRequest;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.vet.VetLivestockResponse;
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
public class VeterinaryAdapter extends TundukAdapter<VetLivestockRequest, VetLivestockResponse> {

    private final XRoadClient xRoadClient;
    private final VetMapper vetMapper;
    private static final String SERVICE_NAME = "vet-cattle";

    @Override
    public VetLivestockResponse call(VetLivestockRequest request) {
        return getLivestockInfo(request.getPin());
    }

    @Override
    public String getServiceName() {
        return SERVICE_NAME;
    }

    @Cacheable(cacheNames = "tunduk-vet-cattle", key = "#pin")
    @Retryable(
            value = {WebServiceIOException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000)
    )
    public VetLivestockResponse getLivestockInfo(String pin) {
        log.info("Fetching livestock info from Veterinary service for PIN: {}", pin);
        Object soapRequest = new VetLivestockRequest(pin);
        Object soapResponse = xRoadClient.callService(soapRequest, SERVICE_NAME);
        return vetMapper.toDto(soapResponse);
    }
}
