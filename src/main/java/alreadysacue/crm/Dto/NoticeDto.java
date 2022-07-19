package alreadysacue.crm.Dto;

import alreadysacue.crm.Repository.NoticeRepository;
import alreadysacue.crm.model.Notice;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.sql.Timestamp;

@AllArgsConstructor
@ToString
public class NoticeDto {
    private Long idx;
    private String title;
    private String content;

    private Timestamp timestamp;

    public Notice toEntity(){
        return new Notice(idx, title, content,timestamp);
    }

}
