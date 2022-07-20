package alreadysacue.crm.Controller;


import alreadysacue.crm.Service.NoticeService;
import alreadysacue.crm.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/calendar")
    public String calendar(){
        return "/Calendar/calendar";
        }

    @GetMapping("/test/nt")
    public String index_testPage(Model model, @PageableDefault(size = 5,sort = "idx",direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("boardList", noticeService.getNoticeList(pageable));
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("check", noticeService.getListCheck(pageable));
        return "test/nt";
    }
}
