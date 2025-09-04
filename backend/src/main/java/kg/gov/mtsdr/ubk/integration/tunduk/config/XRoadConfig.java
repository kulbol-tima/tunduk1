package kg.gov.mtsdr.ubk.integration.tunduk.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import jakarta.xml.soap.MessageFactory;
import jakarta.xml.soap.SOAPConstants;
import jakarta.xml.soap.SOAPException;

@Configuration
public class XRoadConfig {

    @Value("${tunduk.xroad.security-server-url}")
    private String securityServerUrl;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // This context path will need to be updated once WSDLs are processed and JAXB classes are generated.
        // For now, it serves as a placeholder.
        marshaller.setContextPath("kg.gov.tunduk.xroad.wsdl"); // Placeholder
        return marshaller;
    }

    @Bean
    public SaajSoapMessageFactory messageFactory() throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        return new SaajSoapMessageFactory(messageFactory);
    }

    @Bean
    public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller, SaajSoapMessageFactory messageFactory) {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);
        webServiceTemplate.setDefaultUri(securityServerUrl);
        webServiceTemplate.setMessageFactory(messageFactory);
        // Interceptors for X-Road headers will be added here later.
        return webServiceTemplate;
    }
}
