package az.interestmap.interestmap.service;

import az.interestmap.interestmap.dto.repo.UserDTO;

public interface UserService {

    UserDTO saveUser(UserDTO userDTO);

    boolean checkUsernameIsAlreadyUsed(String username);
}
