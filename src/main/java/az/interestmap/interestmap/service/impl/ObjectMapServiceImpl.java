package az.interestmap.interestmap.service.impl;

import az.interestmap.interestmap.constant.UserType;
import az.interestmap.interestmap.dto.controller.UserRegistrationRequestDTO;
import az.interestmap.interestmap.dto.repo.SessionDTO;
import az.interestmap.interestmap.dto.repo.UserDTO;
import az.interestmap.interestmap.entity.Session;
import az.interestmap.interestmap.entity.User;
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
}
