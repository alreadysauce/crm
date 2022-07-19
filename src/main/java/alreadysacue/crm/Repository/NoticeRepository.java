package alreadysacue.crm.Repository;

import alreadysacue.crm.model.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.ArrayList;
import java.util.List;


public interface NoticeRepository extends JpaRepository<Notice, Long> {
    @Override
    ArrayList<Notice>findAll();

    List<Notice> findByTitleContaining(String keyword);


}

