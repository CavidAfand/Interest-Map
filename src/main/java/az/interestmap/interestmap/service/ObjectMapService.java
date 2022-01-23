package az.interestmap.interestmap.service;

import az.interestmap.interestmap.constant.Language;
import az.interestmap.interestmap.dto.controller.UserRegistrationRequestDTO;
import az.interestmap.interestmap.dto.repo.CategoryDTO;
import az.interestmap.interestmap.dto.repo.InterestDTO;
import az.interestmap.interestmap.dto.repo.SessionDTO;
import az.interestmap.interestmap.dto.repo.UserDTO;
import az.interestmap.interestmap.entity.Category;
import az.interestmap.interestmap.entity.Interest;
import az.interestmap.interestmap.entity.Session;
import az.interestmap.interestmap.entity.User;

public interface ObjectMapService {

    User getUserEntityFromDTO(UserDTO userDTO);

    UserDTO getUserDTOFromEntity(User user);

    UserDTO getUserDTOFromUserRegistrationRequestDTO(UserRegistrationRequestDTO userRegistrationRequestDTO);

    Session getSessionEntityFromDTO(SessionDTO sessionDTO);

    SessionDTO getSessionDTOFromEntity(Session session);

    CategoryDTO getCategoryDTOFromEntity(Category category, Language language);

    Category getCategoryEntityFromDTO(CategoryDTO categoryDTO);

    InterestDTO getInterestDTOFromEntity(Interest interest, Language language);

}
