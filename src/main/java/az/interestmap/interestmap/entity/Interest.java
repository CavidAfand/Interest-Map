package az.interestmap.interestmap.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "INTEREST_TABLE")
@Data
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INTEREST_ID")
    private Long interestId;

    @Column(name = "DESCRIPTION", length = 50)
    private String description;

    @Column(name = "DESCRIPTION_AZ", length = 50)
    private String azDescription;

    @ManyToOne
    private Category category;

    @ManyToMany
    private Set<User> userList;
}
