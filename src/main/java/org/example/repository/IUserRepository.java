package org.example.repository;

import org.example.dto.User;

public interface IUserRepository {

    User findUserById(int id);

    void updateBalanceUserByIdAndBalance(User user, long balance);
}
