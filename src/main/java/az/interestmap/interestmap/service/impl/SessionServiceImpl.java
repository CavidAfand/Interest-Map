package az.interestmap.interestmap.service.impl;

import az.interestmap.interestmap.constant.SessionStatus;
import az.interestmap.interestmap.dto.repo.SessionDTO;
import az.interestmap.interestmap.dto.repo.UserDTO;
import az.interestmap.interestmap.entity.Session;
import az.interestmap.interestmap.repository.SessionRepository;
import az.interestmap.interestmap.service.ObjectMapService;
import az.interestmap.interestmap.service.SessionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final ObjectMapService objectMapService;

    public SessionServiceImpl(SessionRepository sessionRepository,
                              ObjectMapService objectMapService) {
        this.sessionRepository = sessionRepository;
        this.objectMapService = objectMapService;
    }

    @Override
    public SessionDTO getSessionBySessionId(String sessionId) {
        Session session = sessionRepository.getSessionBySessionId(sessionId);
        return objectMapService.getSessionDTOFromEntity(session);
    }

    @Override
    public SessionDTO createSession(UserDTO userDTO) {
        Session session = new Session();
        session.setSessionId(UUID.randomUUID().toString());
        session.setStatus(SessionStatus.ACTIVE);
        session.setUser(objectMapService.getUserEntityFromDTO(userDTO));
        session = sessionRepository.save(session);
        return objectMapService.getSessionDTOFromEntity(session);
    }

    @Override
    public void closeSession(String sessionId) {
        Session session = sessionRepository.getSessionBySessionId(sessionId);
        session.setStatus(SessionStatus.CLOSED);
        sessionRepository.save(session);
    }


}
