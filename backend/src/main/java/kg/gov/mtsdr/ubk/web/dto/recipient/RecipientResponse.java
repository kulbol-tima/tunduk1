package kg.gov.mtsdr.ubk.web.dto.recipient;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class RecipientResponse {
    private Long id;
    private String pin;
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate birthDate;
    private String address;
    private String status;
    private BigDecimal currentBenefitAmount;
    private List<HistoryItem> history;

    @Data
    public static class HistoryItem {
        private LocalDate date;
        private String event;
        private String details;
    }
}
