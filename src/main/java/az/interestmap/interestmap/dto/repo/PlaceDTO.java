package az.interestmap.interestmap.dto.repo;

import lombok.Data;

@Data
public class PlaceDTO {

    private Long id;
    private double longitude;
    private double latitude;
    private String title;
    private String description;
    private InterestDTO interestDTO;
    private UserDTO userDTO;

}
