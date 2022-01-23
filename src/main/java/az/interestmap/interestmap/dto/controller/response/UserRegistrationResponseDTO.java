package az.interestmap.interestmap.dto.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserRegistrationResponseDTO {

    @JsonProperty("token")
    private String token;

    @JsonProperty("userType")
    private String userType;

    @JsonProperty("name")
    private String name;
}
