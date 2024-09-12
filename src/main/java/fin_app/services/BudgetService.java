package fin_app.services;

import fin_app.model.Budget;
import fin_app.model.User;
import fin_app.repositories.BudgetRepository;
import fin_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Budget> getBudgetByUserId(Long userId) {
        return budgetRepository.findByUserId(userId);
    }

    public Budget getBudgetById(Long id) {
        return budgetRepository.findById(id).orElse(null);
    }

    public Budget createBudget(Long userId, Budget budget) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            budget.setUser(user);
            return budgetRepository.save(budget);
        }
        return null;
    }

    public Budget updateBudget(Long id, Budget budgetDetails) {
        Budget budget = budgetRepository.findById(id).orElse(null);
        if (budget != null) {
            budget.setAmount(budgetDetails.getAmount());
            budget.setName(budgetDetails.getName());
            budget.setDescription(budgetDetails.getDescription());
            budget.setStartDate(budgetDetails.getStartDate());
            budget.setEndDate(budgetDetails.getEndDate());
            return budgetRepository.save(budget);
        }
        return null;
    }

    public boolean deleteBudget(Long id) {
        if (budgetRepository.existsById(id)) {
            budgetRepository.deleteById(id);
            return true;
        }
        return false;
    }
}