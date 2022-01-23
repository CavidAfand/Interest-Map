package az.interestmap.interestmap.controller;

import az.interestmap.interestmap.dto.ServiceResponse;
import az.interestmap.interestmap.dto.controller.request.NewPlaceRequestDTO;
import az.interestmap.interestmap.dto.controller.request.SearchPlaceRequestDTO;
import az.interestmap.interestmap.dto.controller.response.ClientSearchResponseDTO;
import az.interestmap.interestmap.dto.repo.InterestDTO;
import az.interestmap.interestmap.dto.repo.PlaceDTO;
import az.interestmap.interestmap.dto.repo.UserDTO;
import az.interestmap.interestmap.service.InterestService;
import az.interestmap.interestmap.service.PlaceService;
import az.interestmap.interestmap.service.UserService;
import ch.qos.logback.core.net.server.Client;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
public class PlaceController {

    private final PlaceService placeService;
    private final InterestService interestService;
    private final UserService userService;

    public PlaceController(PlaceService placeService, InterestService interestService, UserService userService) {
        this.placeService = placeService;
        this.interestService = interestService;
        this.userService = userService;
    }

    @PostMapping("/business/place")
    public ServiceResponse addNewPlace(@RequestHeader("Accept-Language") String language,
                                       @RequestHeader("Authorization") String token,
                                       @RequestBody NewPlaceRequestDTO newPlaceRequestDTO,
                                       Principal principal) {
        UserDTO userDTO = userService.getUserByUsername(principal.getName());
        InterestDTO interestDTO = interestService.getInterestById(newPlaceRequestDTO.getInterestId());
        PlaceDTO placeDTO = new PlaceDTO();
        placeDTO.setTitle(newPlaceRequestDTO.getTitle());
        placeDTO.setDescription(newPlaceRequestDTO.getDescription());
        placeDTO.setLongitude(newPlaceRequestDTO.getLongitude());
        placeDTO.setLatitude(newPlaceRequestDTO.getLatitude());
        placeDTO.setInterestDTO(interestDTO);
        placeDTO.setUserDTO(userDTO);
        placeDTO.setDiscount(newPlaceRequestDTO.getDiscount());
        placeService.savePlace(placeDTO);
        return ServiceResponse.getSuccessfulResponse(null);
    }


    @PostMapping("/client/search-places")
    public ServiceResponse<List<ClientSearchResponseDTO>> searchPlaces(@RequestHeader("Authorization") String token,
                                                                       @RequestHeader("Accept-Language") String language,
                                                                       @RequestBody SearchPlaceRequestDTO searchPlaceRequestDTO,
                                                                       Principal principal) {

        List<ClientSearchResponseDTO> clientSearchResponseDTOList = placeService
                .searchInterestingPlaces(searchPlaceRequestDTO.getLatitude(), searchPlaceRequestDTO.getLongitude(), null);

        return ServiceResponse.getSuccessfulResponse(clientSearchResponseDTOList);

    }

}
