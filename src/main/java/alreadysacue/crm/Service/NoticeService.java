package alreadysacue.crm.Service;

import alreadysacue.crm.Repository.NoticeRepository;
import alreadysacue.crm.model.Notice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeService {

    @Autowired
    NoticeRepository noticeRepository;

    @Transactional
    public Page<Notice> search(String keyword,Pageable pageable){
        Page<Notice> noticeList = noticeRepository.findByTitleContaining(keyword, pageable);
        return noticeList;
    }

    @Transactional
    public Page<Notice> getNoticeList(Pageable pageable){
        return noticeRepository.findAll(pageable);
    }
    @Transactional
    public Boolean getListCheck(Pageable pageable) {
        Page<Notice> saved = getNoticeList(pageable);
        Boolean check = saved.hasNext();

        return check;
    }

}