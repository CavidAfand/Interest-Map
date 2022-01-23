package az.interestmap.interestmap.dto.controller.request;

import lombok.Data;

@Data
public class NewPlaceRequestDTO {

    private double longitude;
    private double latitude;
    private String title;
    private String description;
    private int discount;
    private long interestId;

}
