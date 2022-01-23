package az.interestmap.interestmap.dto.controller.response;

import lombok.Data;

@Data
public class ClientSearchResponseDTO {

    private double longitude;
    private double latitude;
    private String title;
    private String description;
    private long discount;
    private String qrId;

}
