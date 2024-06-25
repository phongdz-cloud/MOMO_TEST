package org.example.repository.impl;

import org.example.dto.Account;
import org.example.dto.User;
import org.example.repository.IUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class UserRepositoryImpl implements IUserRepository {

    private volatile static UserRepositoryImpl instance;

    private final List<User> userEntities = new ArrayList<>();

    public synchronized static UserRepositoryImpl getInstance() {
        if(instance == null) {
            instance = new UserRepositoryImpl();
        }

        return instance;
    }

    private UserRepositoryImpl() {
        // init data user
        userEntities.add(new User(1,"phonghh", "123",0));
        userEntities.add(new User(2,"admin","456",0));
        userEntities.add(new User(3,"devops","789",0));
    }

    @Override
    public User findUserById(int id) {
        User userEntity = this.userEntities.stream().filter(user -> Objects.equals(user.getId(), id)).findFirst().orElse(null);

        if(Objects.isNull(userEntity)) {
            throw new NoSuchElementException("User not found");
        }

        return userEntity;
    }

    @Override
    public void updateBalanceUserByIdAndBalance(User user, long balance) {

        if(Objects.isNull(user)) {
            throw new NoSuchElementException("User not found");
        }

        Account account = user.getAccount();
        account.setBalance(balance);
    }
}
