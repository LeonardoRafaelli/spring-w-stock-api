package javastudies.stockapi.service;


import javastudies.stockapi.model.Account;
import javastudies.stockapi.model.User;

public interface UserService {

    User createUser(User newUser);

    void addMoneyToAccount(User user, double amount);
}
