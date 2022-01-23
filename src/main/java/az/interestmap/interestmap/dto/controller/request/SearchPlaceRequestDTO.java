package az.interestmap.interestmap.dto.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SearchPlaceRequestDTO {

    @JsonProperty("lng")
    private double longitude;

    @JsonProperty("lat")
    private double latitude;

}
