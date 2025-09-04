package kg.gov.mtsdr.ubk.integration.tunduk.service;

import kg.gov.mtsdr.ubk.integration.tunduk.adapter.TundukAdapter;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.request.TundukRequest;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.response.TundukResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@SuppressWarnings("rawtypes")
public class TundukIntegrationService {

    private final Map<String, TundukAdapter> adapters;

    public TundukIntegrationService(List<TundukAdapter> adapterList) {
        this.adapters = adapterList.stream()
                .collect(Collectors.toMap(TundukAdapter::getServiceName, Function.identity()));
    }

    @SuppressWarnings("unchecked")
    public <Req extends TundukRequest, Res extends TundukResponse> Res execute(String serviceName, Req request) {
        TundukAdapter<Req, Res> adapter = adapters.get(serviceName);
        if (adapter == null) {
            throw new IllegalArgumentException("No adapter found for service: " + serviceName);
        }
        return adapter.call(request);
    }
}
