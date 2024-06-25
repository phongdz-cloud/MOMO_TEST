package org.example.service.impl;

import org.example.dto.User;
import org.example.repository.IUserRepository;
import org.example.repository.impl.UserRepositoryImpl;
import org.example.service.IUserService;

import java.util.NoSuchElementException;
import java.util.Objects;

public class UserServiceImpl implements IUserService {

    private volatile static UserServiceImpl instance;

    private final IUserRepository userRepository = UserRepositoryImpl.getInstance();

    public synchronized static UserServiceImpl getInstance() {
        if(instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public void depositMoneyToAccount(int id, long balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance must be > 0");
        }

        User userEntity = userRepository.findUserById(id);

        if (Objects.isNull(userEntity)) {
            throw new NoSuchElementException("User not found");
        }

        userRepository.updateBalanceUserByIdAndBalance(userEntity, balance);

        System.out.println("Deposit money into account successfully");

    }

    @Override
    public User findUserById(int id) {
        return userRepository.findUserById(id);
    }
}
