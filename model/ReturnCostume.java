package model;

import java.io.Serializable;

public class ReturnCostume implements Serializable {
    private int id;
    private int quantity;
    private int rentalFee;
    private BorrowCostume borrowCostume;

    public ReturnCostume() {
        super();
    }

    public ReturnCostume(int id, int quantity, int rentalFee, BorrowCostume borrowCostume) {
        super();
        this.id = id;
        this.quantity = quantity;
        this.rentalFee = rentalFee;
        this.borrowCostume = borrowCostume;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getRentalFee() {
        return rentalFee;
    }
    public void setRentalFee(int rentalFee) {
        this.rentalFee = rentalFee;
    }
    public BorrowCostume getBorrowCostume() {
        return borrowCostume;
    }
    public void setBorrowCostume(BorrowCostume borrowCostume) {
        this.borrowCostume = borrowCostume;
    }
}
