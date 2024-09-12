package fin_app.repositories;

import fin_app.model.Earning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EarningRepository extends JpaRepository<Earning, Long> {
    List<Earning> findByUser_Id(Long id);
}