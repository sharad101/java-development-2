package com.example.ledger2.services;


import com.example.ledger2.dao.interfaces.ITransactionDAO;
import com.example.ledger2.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TransactionService {

    private ITransactionDAO transactionDAO;

    @Autowired
    public TransactionService(ITransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }


    public ITransactionDAO getTransactionDAO() {
        return transactionDAO;
    }

    public void setTransactionDAO(ITransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    public Transaction addTransaction(Transaction transaction){
        return transactionDAO.add(transaction);

    }

    public List<Transaction> getAllTransactions(){
        return transactionDAO.getAllTransaction();

    }
}
