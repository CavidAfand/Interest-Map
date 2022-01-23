package az.interestmap.interestmap.service.impl;

import az.interestmap.interestmap.constant.Language;
import az.interestmap.interestmap.constant.UserType;
import az.interestmap.interestmap.dto.controller.UserRegistrationRequestDTO;
import az.interestmap.interestmap.dto.repo.*;
import az.interestmap.interestmap.entity.*;
import az.interestmap.interestmap.service.ObjectMapService;
import org.springframework.stereotype.Service;

@Service
public class ObjectMapServiceImpl implements ObjectMapService {

    @Override
    public User getUserEntityFromDTO(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setType(userDTO.getType());
        user.setName(userDTO.getName());
        return user;
    }

    @Override
    public UserDTO getUserDTOFromEntity(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setType(user.getType());
        return userDTO;
    }

    @Override
    public UserDTO getUserDTOFromUserRegistrationRequestDTO(UserRegistrationRequestDTO userRegistrationRequestDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(userRegistrationRequestDTO.getUsername());
        userDTO.setPassword(userRegistrationRequestDTO.getPassword());
        userDTO.setName(userRegistrationRequestDTO.getName());
        userDTO.setType(userRegistrationRequestDTO.getType());
        return userDTO;
    }

    @Override
    public Session getSessionEntityFromDTO(SessionDTO sessionDTO) {
        Session session = new Session();
        session.setSessionId(sessionDTO.getSessionId());
        session.setUser(getUserEntityFromDTO(sessionDTO.getUser()));
        session.setStatus(sessionDTO.getSessionStatus());
        session.setCreatedAt(sessionDTO.getCreatedAt());
        return session;
    }

    @Override
    public SessionDTO getSessionDTOFromEntity(Session session) {
        SessionDTO sessionDTO = new SessionDTO();
        sessionDTO.setSessionId(session.getSessionId());
        sessionDTO.setUser(getUserDTOFromEntity(session.getUser()));
        sessionDTO.setSessionStatus(session.getStatus());
        sessionDTO.setCreatedAt(session.getCreatedAt());
        return sessionDTO;
    }

    @Override
    public CategoryDTO getCategoryDTOFromEntity(Category category, Language language) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getCategoryId());
        categoryDTO.setDescription(language == Language.az?category.getAzDescription():category.getDescription());
        return categoryDTO;
    }

    @Override
    public Category getCategoryEntityFromDTO(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCategoryId(categoryDTO.getId());
        return category;
    }

    @Override
    public InterestDTO getInterestDTOFromEntity(Interest interest, Language language) {
        InterestDTO interestDTO = new InterestDTO();
        interestDTO.setId(interest.getInterestId());
        interestDTO.setDescription(language == Language.az?interest.getAzDescription():interest.getDescription());
        return interestDTO;
    }

    @Override
    public Interest getInterestEntityFromDTO(InterestDTO interestDTO) {
        Interest interest = new Interest();
        interest.setInterestId(interestDTO.getId());
        return interest;
    }

    @Override
    public Place getPlaceEntityFromDTO(PlaceDTO placeDTO) {
        Place place = new Place();
        place.setId(placeDTO.getId());
        place.setDescription(placeDTO.getDescription());
        place.setTitle(placeDTO.getTitle());
        place.setLongtitude(placeDTO.getLongitude());
        place.setLatitude(placeDTO.getLatitude());
        place.setUser(getUserEntityFromDTO(placeDTO.getUserDTO()));
        place.setInterest(getInterestEntityFromDTO(placeDTO.getInterestDTO()));
        place.setDiscount(placeDTO.getDiscount());
        return place;
    }

    @Override
    public PlaceDTO getPlaceDTOFromEntity(Place place, Language language) {
        PlaceDTO placeDTO = new PlaceDTO();
        placeDTO.setId(place.getId());
        placeDTO.setTitle(place.getTitle());
        placeDTO.setDescription(place.getDescription());
        placeDTO.setLongitude(place.getLongtitude());
        placeDTO.setLatitude(place.getLatitude());
        placeDTO.setUserDTO(getUserDTOFromEntity(place.getUser()));
        placeDTO.setInterestDTO(getInterestDTOFromEntity(place.getInterest(), language));
        placeDTO.setDiscount(place.getDiscount());
        return placeDTO;
    }
}
