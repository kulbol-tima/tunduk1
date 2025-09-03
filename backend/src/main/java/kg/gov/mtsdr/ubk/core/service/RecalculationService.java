package kg.gov.mtsdr.ubk.core.service;

public interface RecalculationService {

    void recalculateByBaseValueChange();

    void recalculateByRegionChange(String regionCode);

    void recalculateByAddressChange(String pin, String newAddress);

    void scheduleAutomaticRecalculation();
}
