package az.interestmap.interestmap.controller;

import az.interestmap.interestmap.dto.ServiceResponse;
import az.interestmap.interestmap.dto.controller.request.LoginRequestDTO;
import az.interestmap.interestmap.dto.controller.response.LoginResponseDTO;
import az.interestmap.interestmap.service.SessionManager;
import az.interestmap.interestmap.service.TokenManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class SessionController {

    private final SessionManager sessionManager;
    private final TokenManager tokenManager;

    public SessionController(SessionManager sessionManager, TokenManager tokenManager) {
        this.sessionManager = sessionManager;
        this.tokenManager = tokenManager;
    }

    @PostMapping("/login")
    public ServiceResponse<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO requestDTO) {
        LoginResponseDTO loginResponseDTO = sessionManager.login(requestDTO.getUsername(), requestDTO.getPassword());
        return ServiceResponse.getSuccessfulResponse(loginResponseDTO);
    }

    @PostMapping("/out")
    public ServiceResponse logout(@RequestHeader("Authorization") String token,
                                  @RequestHeader("Accept-Language") String language,
                                  Principal principal) {
        String sessionId = tokenManager.getSessionId(token);
        sessionManager.closeSession(sessionId);
        return ServiceResponse.getSuccessfulResponse(null);
    }

}
