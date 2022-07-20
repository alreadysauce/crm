package alreadysacue.crm.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Data
public class Notice extends baseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String writer;

}
