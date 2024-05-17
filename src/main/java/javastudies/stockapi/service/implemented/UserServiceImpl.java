package javastudies.stockapi.service.implemented;


import javastudies.stockapi.model.Account;
import javastudies.stockapi.model.User;
import javastudies.stockapi.repository.AccountRepository;
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
    private final AccountRepository accountRepo;
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
    public void addMoneyToAccount(User user, double amount) {
        Account userAccount = user.getAccount();
        userAccount.setBalance(userAccount.getBalance() + amount);
        accountRepo.save(userAccount);
    }


}
