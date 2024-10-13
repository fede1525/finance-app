package fin_app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
    
@Entity
@Getter
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
    private BigDecimal amount;

    @Setter
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Setter
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Setter
    private User user;

    public Budget() {}

    public Budget(Long id, String name, String description, BigDecimal amount, Date startDate, Date endDate, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
    }
}