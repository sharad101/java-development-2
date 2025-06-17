package com.example.ledger2.dao.interfaces;

import com.example.ledger2.models.Transaction;

import java.util.List;

public interface ITransactionDAO {

    /**
     *
     * @param transaction
     * @return
     */

    Transaction add(Transaction transaction);

    List<Transaction> getAllTransaction();

    Transaction getTransactionById(int transactionId);

    void update(int transactionId, Transaction transaction);

    void delete(int transactionId);


}
