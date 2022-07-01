package com.path.controller;

import com.path.param.AccountParam;
import com.path.service.AccountService;
import com.path.transaction.AccountResponse;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    public ResponseEntity createAccount(@RequestBody AccountParam param) {
        accountService.createAccount(param);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<AccountResponse>> getAccounts() {
        List<AccountResponse> responses = accountService.getAccounts();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
