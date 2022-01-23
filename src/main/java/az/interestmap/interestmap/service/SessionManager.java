package az.interestmap.interestmap.service;

import az.interestmap.interestmap.dto.controller.response.LoginResponseDTO;
import az.interestmap.interestmap.dto.repo.SessionDTO;

public interface SessionManager {

    LoginResponseDTO login(String username, String password);

    void closeSession(String sessionId);

}
