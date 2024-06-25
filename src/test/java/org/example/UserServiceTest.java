package org.example;

import org.example.dto.User;
import org.example.service.IUserService;
import org.example.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class UserServiceTest {

    private final IUserService iUserService = UserServiceImpl.getInstance();

    @Test
    public void testDepositAccount() {
        int userId = 1;
        long balance = 1000;
        iUserService.depositMoneyToAccount(userId, balance);

        User userById = iUserService.findUserById(userId);

        assertNotEquals(userById.getAccount().getBalance(), 0);
    }

    @Test(expected = NoSuchElementException.class)
    public void testDepositAccountWhenIdNotFound() {
        int userId = 999;
        iUserService.depositMoneyToAccount(userId, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositAccountWhenBalanceLessThanZero() {
        int userId = 1;
        long balance = -1000;
        iUserService.depositMoneyToAccount(userId, balance);
    }

    @Test
    public void testFindUserById() {
        int userId = 1;
        User userById = iUserService.findUserById(userId);
        assertNotNull(userById);
    }

    @Test(expected = NoSuchElementException.class)
    public void testFindUserByIdWhenNotFound() {
        int userId = 5;
        iUserService.findUserById(userId);
    }
}
