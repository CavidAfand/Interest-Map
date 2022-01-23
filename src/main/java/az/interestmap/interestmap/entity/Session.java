package az.interestmap.interestmap.entity;

import az.interestmap.interestmap.constant.SessionStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SESSION_TABLE")
@Data
public class Session {

    @Id
    @Column(name = "SESION_ID")
    private String sessionId;

    @ManyToOne
    private User user;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private SessionStatus status;

    @Column(name="CREATED_AT")
    private Date createdAt = new Date();

}
