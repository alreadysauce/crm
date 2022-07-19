package alreadysacue.crm.Repository;

import alreadysacue.crm.model.Notice;
import alreadysacue.crm.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Override
    ArrayList<Reservation> findAll();

}
