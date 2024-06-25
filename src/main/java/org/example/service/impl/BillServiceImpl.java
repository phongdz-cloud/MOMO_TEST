package org.example.service.impl;

import org.example.common.DateUtil;
import org.example.dto.Bill;
import org.example.repository.IBillRepository;
import org.example.repository.impl.BillRepositoryImpl;
import org.example.service.IBillService;

import java.util.List;
import java.util.NoSuchElementException;

public class BillServiceImpl implements IBillService {

    private volatile static BillServiceImpl instance;

    private final IBillRepository billRepository = BillRepositoryImpl.getInstance();

    public synchronized static BillServiceImpl getInstance() {
        if(instance == null) {
            instance = new BillServiceImpl();
        }
        return instance;
    }


    @Override
    public Bill addBill(String type, long amount, String dueDate, String provider) {

        if(amount < 0) {
            throw new IllegalArgumentException("Amount must be > 0");
        }

        if(!DateUtil.checkFormatDate(dueDate)) {
            throw new IllegalArgumentException("Due date must be in format dd/MM/yyyy");
        }

        int idBill = billRepository.getIdBill();

        Bill billEntity = new Bill(idBill,type, amount, DateUtil.formatStrToDate(dueDate), provider);

        billRepository.addBill(billEntity);

        return billEntity;
    }

    @Override
    public void updateBillByIdAndAmount(int id, long amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("Amount must be > 0");
        }

        billRepository.updateBillByIdAndAmount(id, amount);
    }

    @Override
    public void deleteBillById(int id) {
        boolean isDeleted = billRepository.deleteBillById(id);
        if(!isDeleted) {
            throw new NoSuchElementException("Bill not found");
        }
    }

    @Override
    public Bill findBillById(int id) {
        Bill billById = billRepository.findBillById(id);
        if(billById == null) {
            throw new NoSuchElementException("Bill not found");
        }
        return billById;
    }

    @Override
    public List<Bill> getAllBill() {
        return billRepository.findAllBill();
    }
}
