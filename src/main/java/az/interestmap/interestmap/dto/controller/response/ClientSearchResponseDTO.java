package az.interestmap.interestmap.dto.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClientSearchResponseDTO {

    private CoordsDTO coords;
    private String title;
    private String description;
    private long discount;
    private String id;

}
