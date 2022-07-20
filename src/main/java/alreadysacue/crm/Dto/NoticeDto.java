package alreadysacue.crm.Dto;

import alreadysacue.crm.model.Notice;
import lombok.AllArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;

@AllArgsConstructor
@ToString
public class NoticeDto{
    private Long idx;
    private String title;
    private String content;
    private String writer;

    private LocalDate createdDate;

    public Notice toEntity(){
        return new Notice(idx, title, content, writer);
    }

}
