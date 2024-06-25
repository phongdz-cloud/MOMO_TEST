package org.example.service;

import org.example.dto.Bill;

import java.util.Date;
import java.util.List;

public interface IBillService {

    Bill addBill(String type, long amount, String dueDate, String provider);

    void updateBillByIdAndAmount(int id, long amount);

    void deleteBillById(int id);

    Bill findBillById(int id);

    List<Bill> getAllBill();
}
