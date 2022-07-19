package alreadysacue.crm.Controller;

import alreadysacue.crm.Dto.NoticeDto;
import alreadysacue.crm.Repository.NoticeRepository;
import alreadysacue.crm.Service.NoticeService;
import alreadysacue.crm.model.Notice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class NoticeController {
    @Autowired
    private NoticeRepository noticeRepository;
    @Autowired
    private NoticeService noticeService;

    //    write notice
    @Secured("ROLE_ADMIN")
    @GetMapping("/notice/write")
//    @ResponseBody // 글자를 그대로 띄워주는 것
    public String noticeWrite(){

        return "notice/noticeWrite";
    }
    @PostMapping("/notice/writeOk")
    public String noticeWriteOk(NoticeDto form){
//        trans dto - > entity
        Notice notice = form.toEntity();
        Notice saved = noticeRepository.save(notice);
        return "redirect:/notice/" + saved.getIdx();
    }
    // List notice (Notice Main)
    @GetMapping("/notice")
    public String notice(Model model, @PageableDefault(sort = "idx",direction = Sort.Direction.DESC) Pageable pageable){
//        find notice
        List<Notice> noticeEntityList = noticeRepository.findAll ();
//        send view
        model.addAttribute("noticeList", noticeEntityList);
        return "notice/notice";
    }

    // Show notice
    @GetMapping("/notice/{idx}")
    public String show(@PathVariable Long idx, Model model){
        log.info("idx = "+idx);
        Notice noticeEntity = noticeRepository.findById(idx).orElse(null);
        model.addAttribute("notice",noticeEntity);
        return"notice/noticeShow";
    }


    //Edit notice
    @Secured("ROLE_ADMIN")
    @GetMapping("/notice/{idx}/edit")
    public String edit(@PathVariable Long idx,Model model){
        Notice noticeEntity = noticeRepository.findById(idx).orElse(null);
        model.addAttribute("notice",noticeEntity);
        return "notice/noticeEdit";
    }

    @PostMapping("/notice/update")
    public String update(NoticeDto form){
        Notice noticeEntity = form.toEntity();
//        log.info(noticeEntity.toString());
        Notice target = noticeRepository.findById(noticeEntity.getIdx()).orElse(null);
//        log.info(target.toString());
        if (target!=null){
            noticeRepository.save(noticeEntity);
        }
        return "redirect:/notice/" + noticeEntity.getIdx();
    }
    //  Delete notice
//  PathVariable mapping
    @Secured("ROLE_ADMIN")
    @GetMapping("/notice/{idx}/delete")
    public String delete(@PathVariable Long idx, RedirectAttributes redirect){
        Notice target = noticeRepository.findById(idx).orElse(null);
        if(target!=null){
            noticeRepository.delete(target);
            redirect.addAttribute("게시물 삭제가 완료되었습니다.");
        }
        return "redirect:/notice";
    }

    @GetMapping("/notice/search")
    public String search(String keyword, Model model){
        //search bar
        List<Notice> searchList = noticeService.search(keyword);
        model.addAttribute("searchList",searchList);

        return "notice/noticeSearch";
    }
}
