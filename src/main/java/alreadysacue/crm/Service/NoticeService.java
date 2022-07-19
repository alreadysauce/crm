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
    public List<Notice> search(String keyword){
        List<Notice> noticeList = noticeRepository.findByTitleContaining(keyword);
        return noticeList;
    }

    @Transactional
    public Page<Notice> getNoticeList(Pageable pageable){
        return noticeRepository.findAll(pageable);
    }

}