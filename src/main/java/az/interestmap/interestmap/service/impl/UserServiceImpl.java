package az.interestmap.interestmap.service.impl;

import az.interestmap.interestmap.dto.repo.UserDTO;
import az.interestmap.interestmap.entity.User;
import az.interestmap.interestmap.exception.ExistedUsernameException;
import az.interestmap.interestmap.repository.UserRepository;
import az.interestmap.interestmap.service.ObjectMapService;
import az.interestmap.interestmap.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ObjectMapService objectMapService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ObjectMapService objectMapService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.objectMapService = objectMapService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        if (checkUsernameIsAlreadyUsed(userDTO.getUsername())) {
            throw new ExistedUsernameException();
        }
        User user = objectMapService.getUserEntityFromDTO(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return objectMapService.getUserDTOFromEntity(user);
    }

    private boolean checkUsernameIsAlreadyUsed(String username) {
        long count = userRepository.countByUsername(username);
        if (count == 0) return false;
        else return true;
    }

}
