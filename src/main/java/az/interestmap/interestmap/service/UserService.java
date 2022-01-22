package az.interestmap.interestmap.service;

import az.interestmap.interestmap.dto.repo.UserDTO;

public interface UserService {

    UserDTO getUserByUsername(String username);

    UserDTO saveUser(UserDTO userDTO);

    boolean checkUsernameIsAlreadyUsed(String username);
}
