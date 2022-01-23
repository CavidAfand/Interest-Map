package az.interestmap.interestmap.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CATEGORY_TABLE")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "DESCRIPTION", length = 50)
    private String description;

    @Column(name = "DESCRIPTION_AZ", length = 50)
    private String azDescription;

    @OneToMany(mappedBy = "category")
    private List<Interest> interestList;

}
