package az.interestmap.interestmap.service.impl;

import az.interestmap.interestmap.dto.repo.SessionDTO;
import az.interestmap.interestmap.service.SessionManager;
import az.interestmap.interestmap.service.SessionService;
import az.interestmap.interestmap.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SessionManagerImpl implements SessionManager {

    private final SessionService sessionService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public SessionManagerImpl(SessionService sessionService, UserService userService, PasswordEncoder passwordEncoder) {
        this.sessionService = sessionService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public SessionDTO login(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);


        return null;
    }

    @Override
    public void closeSession(String sessionId) {

    }
}
