package kg.gov.mtsdr.ubk.integration.tunduk.client;

import kg.gov.mtsdr.ubk.integration.tunduk.config.TundukConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

// Note: These are placeholder imports for JAXB generated classes.
// They will need to be replaced with actual classes from WSDL processing.
// import kg.gov.tunduk.xroad.wsdl.RequestType;
// import kg.gov.tunduk.xroad.wsdl.ResponseType;


@Component
@RequiredArgsConstructor
public class XRoadClient {

    private final WebServiceTemplate webServiceTemplate;
    private final TundukConfig tundukConfig;

    public Object callService(Object request, String serviceName) {
        TundukConfig.Service serviceDetails = tundukConfig.getServices().get(serviceName);
        if (serviceDetails == null) {
            throw new IllegalArgumentException("Service not configured: " + serviceName);
        }

        String soapAction = buildSoapAction(serviceDetails);

        // X-Road headers will be added using a client interceptor, configured on the WebServiceTemplate.
        // The interceptor will use the serviceDetails to construct the headers.

        return webServiceTemplate.marshalSendAndReceive(
                webServiceTemplate.getDefaultUri(),
                request,
                new SoapActionCallback(soapAction)
        );
    }

    private String buildSoapAction(TundukConfig.Service service) {
        // The SOAPAction format can vary. Often it's empty or a specific URN.
        // Using the service code is a reasonable default.
        return service.getServiceCode();
    }

}
