package com.example.ledger2.models;

public class Transaction {
    private int transactionid;
    private double amount;
    private String vendor;

    public Transaction(double amount, String vendor) {
        this.amount = amount;
        this.vendor = vendor;
    }

    public Transaction(int transactionid, double amount, String vendor) {
        this.transactionid = transactionid;
        this.amount = amount;
        this.vendor = vendor;
    }

    public int getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(int transactionid) {
        this.transactionid = transactionid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transactionid=" + transactionid +
                ", amount=" + amount +
                ", vendor='" + vendor + '\'' +
                '}';
    }
}
