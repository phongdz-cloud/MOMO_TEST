package org.example.repository.impl;

import org.example.dto.Bill;
import org.example.repository.IBillRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BillRepositoryImpl implements IBillRepository {

    private volatile static BillRepositoryImpl instance;

    private final List<Bill> billEntites;

    public BillRepositoryImpl() {
        billEntites = new ArrayList<>();
    }

    public synchronized static BillRepositoryImpl getInstance() {
        if(instance == null) {
            instance = new BillRepositoryImpl();
        }
        return instance;
    }


    @Override
    public void addBill(Bill bill) {
        billEntites.add(bill);
    }

    @Override
    public Bill findBillById(int id) {
        return this.billEntites.stream().filter(bill -> bill.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void updateBillByIdAndAmount(int id, long amount) {
        Bill bill = findBillById(id);
        if(bill == null) {
            throw new NoSuchElementException("Bill not found");
        }
        bill.setAmount(amount);
    }

    @Override
    public boolean deleteBillById(int id) {
        Iterator<Bill> billIterator = this.billEntites.iterator();
        while (billIterator.hasNext()) {
            Bill bill = billIterator.next();
            if(bill.getId() == id) {
                billIterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Bill> findAllBill() {
        return new ArrayList<>(this.billEntites);
    }

    @Override
    public int getIdBill() {
        return this.billEntites.size() + 1;
    }
}
