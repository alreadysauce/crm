package alreadysacue.crm.Repository;

import alreadysacue.crm.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;


public interface NoticeRepository extends JpaRepository<Notice, Long> {
    @Override
    ArrayList<Notice>findAll();
}

