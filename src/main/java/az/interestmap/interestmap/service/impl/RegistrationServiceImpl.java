package az.interestmap.interestmap.service.impl;

import az.interestmap.interestmap.dto.controller.UserRegistrationRequestDTO;
import az.interestmap.interestmap.dto.controller.request.UserRegistrationResponseDTO;
import az.interestmap.interestmap.dto.repo.SessionDTO;
import az.interestmap.interestmap.dto.repo.UserDTO;
import az.interestmap.interestmap.service.*;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;
    private final SessionService sessionService;
    private final ObjectMapService objectMapService;
    private final TokenManager tokenManager;

    public RegistrationServiceImpl(UserService userService,
                                   SessionService sessionService, ObjectMapService objectMapService, TokenManager tokenManager) {
        this.userService = userService;
        this.sessionService = sessionService;
        this.objectMapService = objectMapService;
        this.tokenManager = tokenManager;
    }

    @Override
    public UserRegistrationResponseDTO registerUser(UserRegistrationRequestDTO userRegistrationRequestDTO) {
        UserDTO userDTO = objectMapService.getUserDTOFromUserRegistrationRequestDTO(userRegistrationRequestDTO);
        userDTO = userService.registerUser(userDTO);
        SessionDTO sessionDTO = sessionService.createSession(userDTO);
        String token = tokenManager.generateToken(sessionDTO.getSessionId(), userDTO.getUsername());
        UserRegistrationResponseDTO userRegistrationResponseDTO = new UserRegistrationResponseDTO();
        userRegistrationResponseDTO.setToken(token);
        System.out.println(userDTO.toString());
        userRegistrationResponseDTO.setUserType(userDTO.getType().name());
        return userRegistrationResponseDTO;
    }

}
