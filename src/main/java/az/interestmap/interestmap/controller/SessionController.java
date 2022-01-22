package az.interestmap.interestmap.controller;

import az.interestmap.interestmap.dto.ServiceResponse;
import az.interestmap.interestmap.dto.controller.request.LoginRequestDTO;
import az.interestmap.interestmap.dto.controller.response.LoginResponseDTO;
import az.interestmap.interestmap.service.SessionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    private final SessionService sessionService;
//    private final

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public ServiceResponse<LoginResponseDTO> login(LoginRequestDTO requestDTO) {

        return null;
    }

}
