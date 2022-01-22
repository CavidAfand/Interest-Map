package az.interestmap.interestmap.entity;

import az.interestmap.interestmap.constant.UserType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USER_TABLE")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USERNAME", length = 100)
    private String username;

    @Column(name = "NAME", length = 200)
    private String name;

    @Column(name = "PASSWORD", length = 100)
    private String password;

    @Column(name = "TYPE", length = 10)
    @Enumerated(EnumType.STRING)
    private UserType type;

}
