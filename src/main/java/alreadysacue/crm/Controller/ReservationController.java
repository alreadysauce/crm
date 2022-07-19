package alreadysacue.crm.Controller;

import alreadysacue.crm.Dto.ReservationDto;
import alreadysacue.crm.Repository.ReservationRepository;
import alreadysacue.crm.model.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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

    @GetMapping("/admin/management")
    public String Reservation(Model model){
//        find notice
        List<Reservation> reservationEntityList = reservationRepository.findAll ();
//        send view
        model.addAttribute("reservation", reservationEntityList);
        return "Management/management";
    }

    // Show notice
    @GetMapping("/admin/management/{rId}")
    public String show(@PathVariable Long rId, Model model){
        log.info("idx = "+rId);
        Reservation reservationEntityList = reservationRepository.findById(rId).orElse(null);
        model.addAttribute("reservation",reservationEntityList);
        return"Management/managementShow";
    }


    //Edit notice
    @GetMapping("/admin/management/{rId}/edit")
    public String edit(@PathVariable Long rId, Model model){
        Reservation reservationEntity = reservationRepository.findById(rId).orElse(null);
        model.addAttribute("reservation",reservationEntity);
        return "Management/managementEdit";
    }

    @PostMapping("/admin/management/update")
    public String update(ReservationDto form){
        Reservation reservationEntity = form.toEntity();
//        log.info(noticeEntity.toString());
        Reservation target = reservationRepository.findById(reservationEntity.getRId()).orElse(null);
//        log.info(target.toString());
        if (target!=null){
            reservationRepository.save(reservationEntity);
        }
        return "redirect:/management" + reservationEntity.getRId();
    }
    //  Delete notice
//  PathVariable mapping
    @GetMapping("/admin/management/{idx}/delete")
    public String delete(@PathVariable Long r_id, RedirectAttributes redirect){
        Reservation target = reservationRepository.findById(r_id).orElse(null);
        if(target!=null){
            reservationRepository.delete(target);
            redirect.addAttribute("게시물 삭제가 완료되었습니다.");
        }
        return "redirect:/management";
    }
}
