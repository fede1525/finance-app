package fin_app.services;

import fin_app.model.Earning;
import fin_app.model.User;
import fin_app.repositories.EarningRepository;
import fin_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EarningService {

    @Autowired
    private EarningRepository earningRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Earning> getEarningsByUserId(Long userId) {
        return earningRepository.findByUser_Id(userId);
    }

    public Earning getEarningById(Long earningId) {
        return earningRepository.findById(earningId).orElse(null);
    }

    public Earning createEarning(Long userId, Earning earning) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            earning.setUser(user);
            return earningRepository.save(earning);
        }
        return null;
    }

    public Earning updateEarning(Long earningId, Earning earningDetails) {
        Earning earning = earningRepository.findById(earningId).orElse(null);
        if (earning != null) {
            earning.setName((earningDetails.getName()));
            earning.setDescription((earningDetails.getDescription()));
            earning.setAmount((earningDetails.getAmount()));
            earning.setDate((earningDetails.getDate()));
            return earningRepository.save(earning);
        }
        return null;
    }

    public boolean deleteEarning(Long earningId) {
        if (earningRepository.existsById(earningId)) {
            earningRepository.deleteById(earningId);
            return true;
        }
        return false;
    }
}