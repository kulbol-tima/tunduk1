package kg.gov.mtsdr.ubk.integration.tunduk.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Map;

@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties(prefix = "tunduk")
public class TundukConfig {

    @NotNull
    private Map<String, Service> services;

    @Getter
    @Setter
    public static class Service {
        @NotBlank
        private String xroadInstance;
        @NotBlank
        private String memberClass;
        @NotBlank
        private String memberCode;
        @NotBlank
        private String subsystemCode;
        @NotBlank
        private String serviceCode;
        private String serviceVersion;
    }
}
