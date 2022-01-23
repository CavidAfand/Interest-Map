package az.interestmap.interestmap.service;

import az.interestmap.interestmap.dto.repo.SessionDTO;
import az.interestmap.interestmap.dto.repo.UserDTO;
import az.interestmap.interestmap.entity.Session;

public interface SessionService {

    SessionDTO getSessionBySessionId(String sessionId);

    SessionDTO createSession(UserDTO userDTO);

    SessionDTO updateSession(SessionDTO sessionDTO);
}
