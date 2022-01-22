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

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Interest> interestList;

}
