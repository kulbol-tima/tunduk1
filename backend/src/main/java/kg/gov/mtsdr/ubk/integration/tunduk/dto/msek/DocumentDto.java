package kg.gov.mtsdr.ubk.integration.tunduk.dto.msek;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class DocumentDto implements Serializable {
    private String docType;
    private String docSeries;
    private String docNumber;
    private LocalDate docDate;
    private String docAuthority;
}
