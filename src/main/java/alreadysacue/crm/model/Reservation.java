package alreadysacue.crm.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rId;
    @Column
    private String rUsername;
    @Column
    private Integer rPhone;
    @Column
    private String rRequired;
    @Column
    private Integer adultCount;
    @Column
    private Integer kidCount;
    @Column
    private Date rDate;
    @Column
    @CreationTimestamp
    private Timestamp nowDate;
}