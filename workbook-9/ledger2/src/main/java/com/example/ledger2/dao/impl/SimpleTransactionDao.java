package com.example.ledger2.dao.impl;

import com.example.ledger2.dao.interfaces.ITransactionDAO;
import com.example.ledger2.models.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleTransactionDao implements ITransactionDAO {

    private List<Transaction> transactions;

    public SimpleTransactionDao() {
        this.transactions = new ArrayList<>();
        transactions.add(new Transaction(1, 120, "Amazon"));
        transactions.add(new Transaction(2, 160, "Walmart"));
        transactions.add(new Transaction(3, 105, "Best Buy"));
    }

    @Override
    public Transaction add(Transaction transaction) {
        int  maxId = 0;
        for (Transaction t : transactions) {
            if(t.getTransactionid() > maxId){
                maxId = t.getTransactionid();
            }
        }
        transaction.setTransactionid(maxId + 1);
        transactions.add(transaction);
        return transaction;

    }

    @Override
    public List<Transaction> getAllTransaction() {
        return transactions;
    }

    @Override
    public Transaction getTransactionById(int transactionId) {
        for (Transaction transaction : transactions) {
            if(transaction.getTransactionid() == transactionId){
                return transaction;
            }
        }
        return null;
    }

    @Override
    public void update(int transactionId, Transaction transaction) {
        int index = getTransactionIndex(transactionId);
        if (index != -1){
            transactions.set(index, transaction);
        }


    }

    @Override
    public void delete(int transactionId) {
        int index = getTransactionIndex(transactionId);
        if (index != -1){
            transactions.remove(index);
        }

    }

    private int getTransactionIndex(int transactionId){
        for (int i = 0; i < transactions.size(); i++) {
            if(transactions.get(i).getTransactionid() == transactionId){
                return i;
            }
        }
        return -1;
    }
}
