package fin_app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotNull
    private String name;

    @Setter
    @NotNull
    private String surname;

    @Setter
    @NotNull
    private String email;

    @Setter
    @Size(min = 8)
    @NotNull
    private String password;

    @OneToMany(mappedBy = "user")
    @Getter
    private List<Budget> budgets;

    @OneToMany(mappedBy = "user")
    @Getter
    private List<Expense> expenses;

    @OneToMany(mappedBy = "user")
    @Getter
    private List<Earning> earnings;

    public User() {
    }

    public User(long id, String name, String surname, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}