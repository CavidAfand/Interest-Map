package az.interestmap.interestmap.service;

import az.interestmap.interestmap.dto.controller.request.UserRegistrationRequestDTO;
import az.interestmap.interestmap.dto.controller.response.UserRegistrationResponseDTO;

public interface RegistrationService {

    UserRegistrationResponseDTO registerUser(UserRegistrationRequestDTO userRegistrationRequestDTO);

}
