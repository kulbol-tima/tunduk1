package kg.gov.mtsdr.ubk.integration.tunduk.adapter.msek;

import kg.gov.mtsdr.ubk.integration.tunduk.adapter.TundukAdapter;
import kg.gov.mtsdr.ubk.integration.tunduk.client.XRoadClient;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.msek.MsekDisabilityInfoRequest;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.msek.MsekDisabilityInfoResponse;
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
public class MsekAdapter extends TundukAdapter<MsekDisabilityInfoRequest, MsekDisabilityInfoResponse> {

    private final XRoadClient xRoadClient;
    private final MsekMapper msekMapper;
    private static final String SERVICE_NAME = "msek";

    @Override
    public MsekDisabilityInfoResponse call(MsekDisabilityInfoRequest request) {
        return getDisabilityInfo(request.getPin());
    }

    @Override
    public String getServiceName() {
        return SERVICE_NAME;
    }

    @Cacheable(cacheNames = "tunduk-msek", key = "#pin")
    @Retryable(
            value = { WebServiceIOException.class }, // Example: Retry on network I/O errors
            maxAttempts = 3,
            backoff = @Backoff(delay = 3000, multiplier = 2)
    )
    public MsekDisabilityInfoResponse getDisabilityInfo(String pin) {
        log.info("Fetching disability info from MSEK for PIN: {}", pin);

        // Placeholder for creating the actual JAXB request object from the WSDL.
        // The real object would be generated from the WSDL schema.
        Object soapRequest = createSoapRequest(pin);

        // Call the central X-Road client with the request object and service name.
        Object soapResponse = xRoadClient.callService(soapRequest, SERVICE_NAME);

        // Map the raw SOAP response (a JAXB object) to our clean DTO.
        MsekDisabilityInfoResponse responseDto = msekMapper.toDto(soapResponse);

        // Set the original request ID for tracking purposes.
        responseDto.setOriginalRequestId(new MsekDisabilityInfoRequest(pin).getRequestId());

        return responseDto;
    }

    private Object createSoapRequest(String pin) {
        // In a real implementation, this method would instantiate and populate the
        // JAXB-generated request object based on the service's WSDL.
        // For this skeleton, we'll use a simple map to represent the request payload.
        java.util.Map<String, String> request = new java.util.HashMap<>();
        request.put("pin", pin);
        return request;
    }
}
