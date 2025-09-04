package kg.gov.mtsdr.ubk.integration.tunduk.adapter.isrt;

import kg.gov.mtsdr.ubk.integration.tunduk.adapter.TundukAdapter;
import kg.gov.mtsdr.ubk.integration.tunduk.client.XRoadClient;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.isrt.IsrtEmploymentStatusRequest;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.isrt.IsrtEmploymentStatusResponse;
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
public class IsrtAdapter extends TundukAdapter<IsrtEmploymentStatusRequest, IsrtEmploymentStatusResponse> {

    private final XRoadClient xRoadClient;
    private final IsrtMapper isrtMapper;
    private static final String SERVICE_NAME = "isrt-employment";

    @Override
    public IsrtEmploymentStatusResponse call(IsrtEmploymentStatusRequest request) {
        return getEmploymentStatus(request.getPin());
    }

    @Override
    public String getServiceName() {
        return SERVICE_NAME;
    }

    @Cacheable(cacheNames = "tunduk-isrt-employment", key = "#pin")
    @Retryable(
            value = {WebServiceIOException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000)
    )
    public IsrtEmploymentStatusResponse getEmploymentStatus(String pin) {
        log.info("Fetching employment status from ISRT for PIN: {}", pin);
        Object soapRequest = new IsrtEmploymentStatusRequest(pin);
        Object soapResponse = xRoadClient.callService(soapRequest, SERVICE_NAME);
        return isrtMapper.toDto(soapResponse);
    }
}
