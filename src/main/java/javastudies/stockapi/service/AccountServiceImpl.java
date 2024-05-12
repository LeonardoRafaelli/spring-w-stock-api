package javastudies.stockapi.service;

import javastudies.stockapi.model.Account;
import javastudies.stockapi.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepo;

    @Override
    public Account createAccount() {
        Account account = new Account();
        return accountRepo.save(account);
    }
}
