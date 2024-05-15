package javastudies.stockapi.service;


import javastudies.stockapi.model.Account;
import javastudies.stockapi.model.User;
import javastudies.stockapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

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

    @Override
    public Account getUserAccount(String userEmail) {
        return null;
    }


}
