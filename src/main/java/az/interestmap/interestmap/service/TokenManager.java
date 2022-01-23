package az.interestmap.interestmap.service;

import java.util.Map;

public interface TokenManager {

    String generateToken(String sessionId, String username);

    String getUsername(String token);

    String getSessionId(String token);

    Map<String, String> getInfoFromToken(String token);

}
