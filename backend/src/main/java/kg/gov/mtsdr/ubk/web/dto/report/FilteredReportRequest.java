package kg.gov.mtsdr.ubk.web.dto.report;

import lombok.Data;
import java.util.List;

@Data
public class FilteredReportRequest {
    private boolean largeFamilies;
    private boolean borderlandResidents;
    private boolean withDisabilities;
    private List<String> regions;
}
