package az.interestmap.interestmap.service;

import az.interestmap.interestmap.dto.controller.response.ClientSearchResponseDTO;
import az.interestmap.interestmap.dto.repo.InterestDTO;
import az.interestmap.interestmap.dto.repo.PlaceDTO;

import java.util.List;

public interface PlaceService {

    PlaceDTO savePlace(PlaceDTO placeDTO);

    List<ClientSearchResponseDTO> searchInterestingPlaces(String userLatitude, String userLongitude,
                                                          List<InterestDTO> userInterestList);

}
