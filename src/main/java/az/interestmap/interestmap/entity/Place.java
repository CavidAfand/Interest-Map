package az.interestmap.interestmap.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PLACE")
@Data
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "LONGTITUDE")
    private Double longtitude;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    private Interest interest;

    @ManyToOne
    private User user;

}
