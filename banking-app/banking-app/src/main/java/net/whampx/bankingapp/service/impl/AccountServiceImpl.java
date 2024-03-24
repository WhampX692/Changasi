package net.whampx.bankingapp.service.impl;

import net.whampx.bankingapp.dto.AccountDto;
import net.whampx.bankingapp.entity.Account;
import net.whampx.bankingapp.mapper.AccountMapper;
import net.whampx.bankingapp.repository.AccountRepository;
import net.whampx.bankingapp.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
   private AccountRepository accountRepository;


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount= accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
