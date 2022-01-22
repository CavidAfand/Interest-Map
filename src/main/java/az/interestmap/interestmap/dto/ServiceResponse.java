package az.interestmap.interestmap.dto;

import lombok.Data;

@Data
public class ServiceResponse<T> {

    private boolean successful;
    private ErrorDTO error;
    private T payload;

    public static <T> ServiceResponse<T> getSuccessfulResponse(T payload) {
        ServiceResponse<T> serviceResponse = new ServiceResponse<>();
        serviceResponse.setSuccessful(true);
        serviceResponse.setPayload(payload);
        return serviceResponse;
    }

    public static <T> ServiceResponse<T> getErrorResponse(String code, String message) {
        ServiceResponse<T> serviceResponse = new ServiceResponse<>();
        serviceResponse.setSuccessful(false);
        serviceResponse.setError(new ErrorDTO(code, message));
        return serviceResponse;
    }

}
