package az.interestmap.interestmap.dto.repo;

import az.interestmap.interestmap.constant.UserType;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private String name;
    private UserType type;

}
