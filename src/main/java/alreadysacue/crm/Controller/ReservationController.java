package alreadysacue.crm.Controller;


import alreadysacue.crm.Dto.ReservationDto;
import alreadysacue.crm.Repository.ReservationRepository;
import alreadysacue.crm.model.Notice;
import alreadysacue.crm.model.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;
    @GetMapping("/reservation")
    public String rForm(){
        return "/Reservation/reservationForm";
    }
    @PostMapping("/reservationOK")
    public String rOk(ReservationDto form){
        Reservation reservation = form.toEntity();
        log.info(form.toString());
        Reservation saved = reservationRepository.save(reservation);
        log.info(reservation.toString());
        return "redirect:/";
    }
}
