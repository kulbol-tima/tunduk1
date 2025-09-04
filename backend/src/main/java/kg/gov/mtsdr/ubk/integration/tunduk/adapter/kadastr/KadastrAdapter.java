package kg.gov.mtsdr.ubk.integration.tunduk.adapter.kadastr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KadastrAdapter {

    public Object getRealEstateInfo(String pin) {
        log.warn("Kadastr Real Estate Info service is not yet implemented.");
        throw new UnsupportedOperationException("Kadastr Real Estate Info service is not available yet.");
    }
}
