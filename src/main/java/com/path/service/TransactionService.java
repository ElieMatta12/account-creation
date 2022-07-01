package com.path.service;

import com.path.model.Account;
import com.path.model.Transaction;
import com.path.repository.TransactionRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void createTransaction(Account account, float amount) {
        Transaction transaction = new Transaction(account, amount);
        transactionRepository.save(transaction);
    }

    public Map<Integer, List<Transaction>> getTransactionsMappedByAccountId() {
        return
            transactionRepository.findAll().stream()
                .collect(Collectors.groupingBy(transaction -> transaction.getAccountId(), HashMap::new, Collectors.toCollection(ArrayList::new)));
    }
}
