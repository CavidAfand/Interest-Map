package az.interestmap.interestmap.dto.repo;

import az.interestmap.interestmap.constant.SessionStatus;
import lombok.Data;

import java.util.Date;

@Data
public class SessionDTO {

    private String sessionId;
    private UserDTO user;
    private SessionStatus sessionStatus;
    private Date createdAt;

}
