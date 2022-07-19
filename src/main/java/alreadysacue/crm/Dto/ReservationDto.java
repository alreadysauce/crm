package alreadysacue.crm.Dto;

import alreadysacue.crm.model.Reservation;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@ToString
public class ReservationDto {
    private Long rId;
    private String rUsername;
    private Integer rNumber;
    private String rPhone;
    private String rRequired;
    private Integer adultCount;
    private Integer kidCount;
    private Date rDate;
    private Timestamp nowDate;
    public Reservation toEntity(){
        return new Reservation(rId, rUsername, rNumber, rPhone, rRequired, adultCount, kidCount, rDate, nowDate);
    }
}

