package fin_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fin_app.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}