package az.interestmap.interestmap.service;

import az.interestmap.interestmap.dto.repo.SessionDTO;

public interface SessionManager {

    SessionDTO login(String username, String password);

    void closeSession(String sessionId);

}
