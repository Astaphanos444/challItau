package com.challItau.demo.service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Service;

import com.challItau.demo.model.Transaction;

@Service
public class TransactionService {
    public TransactionService() {}

    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public void addTransaction(Transaction transaction)
    {
        transactions.add(transaction);
    }

    public void clearTransaction()
    {
        transactions.clear();
    }

    public DoubleSummaryStatistics getStatistics()
    {
        OffsetDateTime now = OffsetDateTime.now();
        return transactions.stream()
            .filter(c -> c.getDataHora().isAfter(now.minusSeconds(60)))
            .mapToDouble(Transaction::getValor)
            .summaryStatistics();
    }
}
