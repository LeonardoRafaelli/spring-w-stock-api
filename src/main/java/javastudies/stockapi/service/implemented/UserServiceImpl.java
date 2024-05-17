package javastudies.stockapi.service.implemented;


import javastudies.stockapi.model.User;
import javastudies.stockapi.repository.UserRepository;
import javastudies.stockapi.model.UserRole;
import javastudies.stockapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final AccountServiceImpl accountService;

    @Override
    public User createUser(User newUser) {
        newUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
        newUser.setRole(UserRole.USER);
        // Creates new user Account
        newUser.setAccount(accountService.createAccount());
        return userRepo.save(newUser);
    }


}