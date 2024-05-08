package javastudies.stockapi.model;

import jakarta.persistence.*;
import javastudies.stockapi.service.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Data
@Builder
@AllArgsConstructor
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

}
