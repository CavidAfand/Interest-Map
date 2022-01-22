package az.interestmap.interestmap.service.impl;

import az.interestmap.interestmap.constant.SessionStatus;
import az.interestmap.interestmap.dto.controller.response.LoginResponseDTO;
import az.interestmap.interestmap.dto.repo.SessionDTO;
import az.interestmap.interestmap.dto.repo.UserDTO;
import az.interestmap.interestmap.exception.custom.PasswordNotMatchedException;
import az.interestmap.interestmap.service.SessionManager;
import az.interestmap.interestmap.service.SessionService;
import az.interestmap.interestmap.service.TokenManager;
import az.interestmap.interestmap.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SessionManagerImpl implements SessionManager {

    private final SessionService sessionService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final TokenManager tokenManager;

    public SessionManagerImpl(SessionService sessionService, UserService userService, PasswordEncoder passwordEncoder, TokenManager tokenManager) {
        this.sessionService = sessionService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.tokenManager = tokenManager;
    }

    @Override
    public LoginResponseDTO login(String username, String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        UserDTO userDTO = userService.getUserByUsername(username);
        if (!passwordEncoder.matches(password, userDTO.getPassword())) {
            throw new PasswordNotMatchedException();
        }
        SessionDTO sessionDTO = sessionService.createSession(userDTO);
        String token = tokenManager.generateToken(sessionDTO.getSessionId(), userDTO.getUsername());
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setToken(token);
        loginResponseDTO.setUserType(userDTO.getType().name());
        return loginResponseDTO;
    }

    @Override
    public void closeSession(String sessionId) {
        SessionDTO sessionDTO = sessionService.getSessionBySessionId(sessionId);
        sessionDTO.setSessionStatus(SessionStatus.CLOSED);
        sessionService.updateSession(sessionDTO);
    }
}
