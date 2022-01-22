package az.interestmap.interestmap.controller;

import az.interestmap.interestmap.dto.ServiceResponse;
import az.interestmap.interestmap.dto.controller.request.LoginRequestDTO;
import az.interestmap.interestmap.dto.controller.response.LoginResponseDTO;
import az.interestmap.interestmap.service.SessionManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SessionController {

    private final SessionManager sessionManager;

    public SessionController(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @PostMapping("/login")
    public ServiceResponse<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO requestDTO) {
        LoginResponseDTO loginResponseDTO = sessionManager.login(requestDTO.getUsername(), requestDTO.getPassword());
        return ServiceResponse.getSuccessfulResponse(loginResponseDTO);
    }

}
