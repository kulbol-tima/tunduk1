package kg.gov.mtsdr.ubk.integration.tunduk.adapter;

import kg.gov.mtsdr.ubk.integration.tunduk.dto.request.TundukRequest;
import kg.gov.mtsdr.ubk.integration.tunduk.dto.response.TundukResponse;

public abstract class TundukAdapter<Req extends TundukRequest, Res extends TundukResponse> {

    /**
     * Executes the service call.
     *
     * @param request the service request DTO
     * @return the service response DTO
     */
    public abstract Res call(Req request);

    /**
     * Returns the unique name of the service this adapter is for.
     * This name should match a key in the tunduk.services configuration.
     *
     * @return the service name
     */
    public abstract String getServiceName();
}
