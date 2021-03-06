package alreadysacue.crm.Repository;

import alreadysacue.crm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
//    SELECT * FROM USER WHERE username = ?
    public User findByUsername(String username);
}
