package kg.gov.mtsdr.ubk.integration.tunduk.adapter.gns;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GnsAdapter {

    public Object getPatentInfo(String pin) {
        log.warn("GNS Patent Info service is not yet implemented.");
        throw new UnsupportedOperationException("GNS Patent Info service is not available yet.");
    }

    public Object getIndividualEntrepreneurInfo(String pin) {
        log.warn("GNS Individual Entrepreneur Info service is not yet implemented.");
        throw new UnsupportedOperationException("GNS Individual Entrepreneur Info service is not available yet.");
    }
}
