package org.example;

import org.example.service.IBillService;
import org.example.service.impl.BillServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class BillServiceImplTest {

    private final IBillService iBillService = BillServiceImpl.getInstance();


    @Test
    public void testAddBill() {
        iBillService.addBill("Electricity", 100000, "19/08/1999", "EVN");

        Assert.assertEquals(iBillService.getAllBill().size(), 1);
    }

    @Test
    public void testAddBillWhenAmountLessThanZero() {
        try {
            iBillService.addBill("Electricity", -100000, "19/08/1999", "EVN");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Amount must be > 0");
        }
    }

    @Test
    public void testAddBillWhenDueDateInvalid() {
        try {
            iBillService.addBill("Electricity", 100000, "1999/08/19", "EVN");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Due date must be in format dd/MM/yyyy");
        }
    }

    @Test
    public void testUpdateBillByIdAndAmount() {
        iBillService.addBill("Electricity", 100000, "19/08/1999", "EVN");

        iBillService.updateBillByIdAndAmount(1, 200000);

        Assert.assertEquals(iBillService.findBillById(1).getAmount(), 200000);
    }

    @Test
    public void testUpdateBillByIdAndAmountWhenAmountLessThanZero() {
        try {
            iBillService.addBill("Electricity", 100000, "19/08/1999", "EVN");

            iBillService.updateBillByIdAndAmount(1, -200000);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Amount must be > 0");
        }
    }

    @Test
    public void testUpdateBillByIdAndAmountWhenIdNotFound() {
        try {
            iBillService.updateBillByIdAndAmount(1, 200000);
        } catch (NoSuchElementException e) {
            Assert.assertEquals(e.getMessage(), "Bill not found");
        }
    }

    @Test
    public void testDeleteBillById() {
        iBillService.addBill("Electricity", 100000, "19/08/1999", "EVN");

        iBillService.deleteBillById(1);

        Assert.assertEquals(iBillService.getAllBill().size(), 0);
    }

    @Test
    public void testDeleteBillByIdWhenIdNotFound() {
        try {
            iBillService.deleteBillById(1);
        } catch (NoSuchElementException e) {
            Assert.assertEquals(e.getMessage(), "Bill not found");
        }
    }

    @Test
    public void testFindBillById() {
        iBillService.addBill("Electricity", 100000, "19/08/1999", "EVN");

        Assert.assertEquals(iBillService.findBillById(1).getId(), 1);
    }

    @Test
    public void testFindBillByIdWhenIdNotFound() {
        try {
            iBillService.findBillById(1);
        } catch (NoSuchElementException e) {
            Assert.assertEquals(e.getMessage(), "Bill not found");
        }
    }

    @Test
    public void testGetAllBill() {
        iBillService.addBill("Electricity", 100000, "19/08/1999", "EVN");
        iBillService.addBill("Water", 200000, "19/08/1999", "WATER");

        Assert.assertEquals(iBillService.getAllBill().size(), 2);
    }
}
