package az.interestmap.interestmap.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "QR_CODE")
@Data
public class QrCode {

    @Id
    @Column(name = "QR_ID")
    private Long qrId;

    @ManyToOne
    private User businessUser;

    @ManyToOne
    private User clientUser;


}
