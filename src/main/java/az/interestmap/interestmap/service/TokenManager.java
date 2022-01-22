package az.interestmap.interestmap.service;

public interface TokenManager {

    String generateToken(String sessionId, String username);

    String getUsername(String token);

}
