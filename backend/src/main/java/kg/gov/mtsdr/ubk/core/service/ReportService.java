package kg.gov.mtsdr.ubk.core.service;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface ReportService {

    ByteArrayInputStream generateMonthlyReport();

    ByteArrayInputStream generatePaymentReport();

    // The return type could be a List of entities or a custom report DTO
    Object filterByCategories(List<String> categories);
}
