package az.interestmap.interestmap.service;

import az.interestmap.interestmap.constant.Language;
import az.interestmap.interestmap.dto.controller.request.UserRegistrationRequestDTO;
import az.interestmap.interestmap.dto.repo.*;
import az.interestmap.interestmap.entity.*;

public interface ObjectMapService {

    User getUserEntityFromDTO(UserDTO userDTO);

    UserDTO getUserDTOFromEntity(User user);

    UserDTO getUserDTOFromUserRegistrationRequestDTO(UserRegistrationRequestDTO userRegistrationRequestDTO);

    Session getSessionEntityFromDTO(SessionDTO sessionDTO);

    SessionDTO getSessionDTOFromEntity(Session session);

    CategoryDTO getCategoryDTOFromEntity(Category category, Language language);

    Category getCategoryEntityFromDTO(CategoryDTO categoryDTO);

    InterestDTO getInterestDTOFromEntity(Interest interest, Language language);

    Interest getInterestEntityFromDTO(InterestDTO interestDTO);

    Place getPlaceEntityFromDTO(PlaceDTO placeDTO);

    PlaceDTO getPlaceDTOFromEntity(Place place, Language language);


}
