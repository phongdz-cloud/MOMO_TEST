package org.example.service;

import org.example.dto.User;

public interface IUserService {
    void depositMoneyToAccount(int id, long balance);

    User findUserById(int id);
}
