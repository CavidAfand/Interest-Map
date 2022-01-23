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
//        List<InterestDTO> interestDTOList = userService.getUserByUsername(principal).

        return ServiceResponse.getSuccessfulResponse(getMockResponse());

    }


    private List<ClientSearchResponseDTO> getMockResponse() {
        ClientSearchResponseDTO clientSearchResponseDTO = new ClientSearchResponseDTO();
        clientSearchResponseDTO.setLongitude(40.3714273);
        clientSearchResponseDTO.setLatitude(49.8488692);
        clientSearchResponseDTO.setTitle("title");
        clientSearchResponseDTO.setDescription("desc");
        clientSearchResponseDTO.setDiscount(2);
        clientSearchResponseDTO.setQrId(UUID.randomUUID().toString());

        ClientSearchResponseDTO clientSearchResponseDTO2 = new ClientSearchResponseDTO();
        clientSearchResponseDTO2.setLongitude(40.37687468467695);
        clientSearchResponseDTO2.setLatitude(49.8543743187519);
        clientSearchResponseDTO2.setTitle("title 2");
        clientSearchResponseDTO2.setDescription("desc 2");
        clientSearchResponseDTO2.setDiscount(3);
        clientSearchResponseDTO2.setQrId(UUID.randomUUID().toString());

        ClientSearchResponseDTO clientSearchResponseDTO3 = new ClientSearchResponseDTO();
        clientSearchResponseDTO3.setLongitude(49.85034154415636);
        clientSearchResponseDTO3.setLatitude(40.370708473110625);
        clientSearchResponseDTO3.setTitle("Park inn");
        clientSearchResponseDTO3.setDescription("Sadəcə otel");
        clientSearchResponseDTO3.setDiscount(0);
        clientSearchResponseDTO3.setQrId(UUID.randomUUID().toString());

        ClientSearchResponseDTO clientSearchResponseDTO4 = new ClientSearchResponseDTO();
        clientSearchResponseDTO4.setLongitude(40.36905145629148);
        clientSearchResponseDTO4.setLatitude(49.843456882787045);
        clientSearchResponseDTO4.setTitle("Sumqayıt inn");
        clientSearchResponseDTO4.setDescription("Belə yer yoxdur");
        clientSearchResponseDTO4.setDiscount(1);
        clientSearchResponseDTO4.setQrId(UUID.randomUUID().toString());

        ClientSearchResponseDTO clientSearchResponseDTO5 = new ClientSearchResponseDTO();
        clientSearchResponseDTO5.setLongitude(40.0253);
        clientSearchResponseDTO5.setLatitude(48.2015);
        clientSearchResponseDTO5.setTitle("Uydurma park");
        clientSearchResponseDTO5.setDescription("At tut düzələcək");
        clientSearchResponseDTO5.setDiscount(6);
        clientSearchResponseDTO5.setQrId(UUID.randomUUID().toString());

        return List.of(clientSearchResponseDTO, clientSearchResponseDTO2, clientSearchResponseDTO3, clientSearchResponseDTO4, clientSearchResponseDTO5);
    }
}
