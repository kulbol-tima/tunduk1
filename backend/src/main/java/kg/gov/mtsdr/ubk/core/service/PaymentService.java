package kg.gov.mtsdr.ubk.core.service;

import kg.gov.mtsdr.ubk.common.entity.Recipient;
import kg.gov.mtsdr.ubk.web.dto.PaymentOrderDto;

import java.util.List;

public interface PaymentService {

    PaymentOrderDto generatePaymentOrder(List<Recipient> recipients);

    void processPayment(PaymentOrderDto paymentOrder);

    void generateMonthlyPayments();

    void sendPaymentToBanks();
}
