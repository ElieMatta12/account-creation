package com.path.service;

import com.path.model.Customer;
import com.path.model.Transaction;
import com.path.param.AccountParam;
import com.path.repository.CustomersRepository;
import com.path.transaction.AccountResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.stereotype.Service;

import com.path.model.Account;
import com.path.repository.AccountsRepository;

@Service
public class AccountService {

    private final AccountsRepository accountsRepository;
    private final CustomersRepository customersRepository;

    private final TransactionService transactionService;

    public AccountService(AccountsRepository accountsRepository, CustomersRepository customersRepository,
        TransactionService transactionService) {
        this.accountsRepository = accountsRepository;
        this.customersRepository = customersRepository;
        this.transactionService = transactionService;
    }

    public void createAccount(AccountParam param) {
        Customer customer = customersRepository.findById(param.getCustomerId())
            .orElseThrow(() -> new IllegalArgumentException("Invalid customer id " + param.getCustomerId()));

        Account account = new Account(customer, param.getInitialCredit());
        accountsRepository.save(account);

        if (param.getInitialCredit() > 0) {
            transactionService.createTransaction(account, param.getInitialCredit());
        }
    }

    public List<AccountResponse> getAccounts() {
        List<Account> accounts = accountsRepository.findAll();

        Map<Integer, List<Transaction>> transactionsMap = transactionService.getTransactionsMappedByAccountId();

        List<AccountResponse> responses = new ArrayList<>();

        accounts.forEach(account -> {
            float balance = 0f;

            List<Transaction> accountTransactions = transactionsMap.get(account.getId());
            if (accountTransactions != null) {
                for (Transaction accountTransaction : accountTransactions) {
                    balance += accountTransaction.getAmount();
                }
            }

            responses.add(new AccountResponse(account.getCustomer().getName(), account.getCustomer().getSurname(), balance, accountTransactions));
        });

        return responses;
    }
}
