package javastudies.stockapi.repository;

import javastudies.stockapi.model.User;
import javastudies.stockapi.security.CustomUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findUserByEmail(String email);

}
