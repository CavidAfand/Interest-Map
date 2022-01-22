package az.interestmap.interestmap.service.impl;

import az.interestmap.interestmap.dto.controller.UserRegistrationRequestDTO;
import az.interestmap.interestmap.dto.controller.request.UserRegistrationResponseDTO;
import az.interestmap.interestmap.dto.repo.SessionDTO;
import az.interestmap.interestmap.dto.repo.UserDTO;
import az.interestmap.interestmap.exception.custom.ExistedUsernameException;
import az.interestmap.interestmap.service.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;
    private final SessionService sessionService;
    private final ObjectMapService objectMapService;
    private final TokenManager tokenManager;
    private final PasswordEncoder passwordEncoder;

    public RegistrationServiceImpl(UserService userService,
                                   SessionService sessionService, ObjectMapService objectMapService, TokenManager tokenManager, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.sessionService = sessionService;
        this.objectMapService = objectMapService;
        this.tokenManager = tokenManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserRegistrationResponseDTO registerUser(UserRegistrationRequestDTO userRegistrationRequestDTO) {
        UserDTO userDTO = objectMapService.getUserDTOFromUserRegistrationRequestDTO(userRegistrationRequestDTO);
        if (userService.checkUsernameIsAlreadyUsed(userDTO.getUsername())) {
            throw new ExistedUsernameException();
        }
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userDTO = userService.saveUser(userDTO);
        SessionDTO sessionDTO = sessionService.createSession(userDTO);
        String token = tokenManager.generateToken(sessionDTO.getSessionId(), userDTO.getUsername());
        UserRegistrationResponseDTO userRegistrationResponseDTO = new UserRegistrationResponseDTO();
        userRegistrationResponseDTO.setToken(token);
        userRegistrationResponseDTO.setUserType(userDTO.getType().name());
        userRegistrationResponseDTO.setName(userDTO.getName());
        return userRegistrationResponseDTO;
    }

}
