package alreadysacue.crm.Dto;

import alreadysacue.crm.model.Notice;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class NoticeDto {
    private Long idx;
    private String title;
    private String content;
//

    public Notice toEntity(){
        return new Notice(idx, title, content);
    }
}
