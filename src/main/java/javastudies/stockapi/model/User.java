package javastudies.stockapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToOne
    private Account account;

}
