package az.interestmap.interestmap.repository;

import az.interestmap.interestmap.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, String> {

    Session getSessionBySessionId(String session);

}
