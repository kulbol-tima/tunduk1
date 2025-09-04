package kg.gov.mtsdr.ubk.integration.tunduk.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class TundukRestClient {

    private final RestTemplate restTemplate;

    public <T> T get(String url, Class<T> responseType, Object... uriVariables) {
        return restTemplate.getForObject(url, responseType, uriVariables);
    }

    public <T> T post(String url, Object request, Class<T> responseType) {
        return restTemplate.postForObject(url, request, responseType);
    }

    // A RestTemplate bean should be configured elsewhere in the application,
    // for example in a @Configuration class, to set up error handling, message converters, etc.
}
