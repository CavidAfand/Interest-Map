package az.interestmap.interestmap.dto.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserRegistrationResponseDTO {

    @JsonProperty("token")
    private String token;

    @JsonProperty("userType")
    private String userType;

}
