package az.interestmap.interestmap.service;

import az.interestmap.interestmap.dto.controller.UserRegistrationRequestDTO;
import az.interestmap.interestmap.dto.controller.request.UserRegistrationResponseDTO;

public interface RegistrationService {

    UserRegistrationResponseDTO registerUser(UserRegistrationRequestDTO userRegistrationRequestDTO);

}
