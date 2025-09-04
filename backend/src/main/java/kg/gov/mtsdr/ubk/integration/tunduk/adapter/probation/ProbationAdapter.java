package kg.gov.mtsdr.ubk.integration.tunduk.adapter.probation;

import kg.gov.mtsdr.ubk.integration.tunduk.adapter.TundukAdapter;
import kg.gov.mtsdr.ubk.integration.tunduk.client.XRoadClient;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.probation.ProbationClientInfoResponse;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.probation.ProbationRequest;
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
public class ProbationAdapter extends TundukAdapter<ProbationRequest, ProbationClientInfoResponse> {

    private final XRoadClient xRoadClient;
    private final ProbationMapper probationMapper;
    private static final String SERVICE_NAME = "probation-client-info";

    @Override
    public ProbationClientInfoResponse call(ProbationRequest request) {
        return getProbationClientInfo(request.getPin());
    }

    @Override
    public String getServiceName() {
        return SERVICE_NAME;
    }

    @Cacheable(cacheNames = "tunduk-probation-info", key = "#pin")
    @Retryable(
            value = {WebServiceIOException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000)
    )
    public ProbationClientInfoResponse getProbationClientInfo(String pin) {
        log.info("Fetching client info from Probation service for PIN: {}", pin);
        Object soapRequest = new ProbationRequest(pin);
        Object soapResponse = xRoadClient.callService(soapRequest, SERVICE_NAME);
        return probationMapper.toDto(soapResponse);
    }
}
