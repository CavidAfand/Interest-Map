package az.interestmap.interestmap.service;

import az.interestmap.interestmap.dto.controller.UserRegistrationRequestDTO;
import az.interestmap.interestmap.dto.repo.SessionDTO;
import az.interestmap.interestmap.dto.repo.UserDTO;
import az.interestmap.interestmap.entity.Session;
import az.interestmap.interestmap.entity.User;

public interface ObjectMapService {

    User getUserEntityFromDTO(UserDTO userDTO);

    UserDTO getUserDTOFromEntity(User user);

    UserDTO getUserDTOFromUserRegistrationRequestDTO(UserRegistrationRequestDTO userRegistrationRequestDTO);

    Session getSessionEntityFromDTO(SessionDTO sessionDTO);

    SessionDTO getSessionDTOFromEntity(Session session);

}
