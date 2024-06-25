package org.example.repository;

import org.example.dto.Bill;

import java.util.List;

public interface IBillRepository {
    void addBill(Bill bill);

    Bill findBillById(int id);

    void updateBillByIdAndAmount(int id, long balance);

    boolean deleteBillById(int id);

    List<Bill> findAllBill();

    int getIdBill();
}
