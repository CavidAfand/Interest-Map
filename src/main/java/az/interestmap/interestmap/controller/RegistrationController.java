package az.interestmap.interestmap.controller;

import az.interestmap.interestmap.dto.ServiceResponse;
import az.interestmap.interestmap.dto.controller.UserRegistrationRequestDTO;
import az.interestmap.interestmap.dto.controller.request.UserRegistrationResponseDTO;
import az.interestmap.interestmap.service.RegistrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/registration")
    public ServiceResponse<UserRegistrationResponseDTO> registerUser(
            @RequestHeader("Accept-Language") String language,
            @RequestBody @Valid UserRegistrationRequestDTO requestDTO
    ) {
        UserRegistrationResponseDTO userRegistrationResponseDTO = registrationService.registerUser(requestDTO);
        return ServiceResponse.getSuccessfulResponse(userRegistrationResponseDTO);
    }

}
