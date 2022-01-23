package az.interestmap.interestmap.dto.repo;

import az.interestmap.interestmap.constant.UserType;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private String name;
    private UserType type;
    private List<Long> interestList;

}
