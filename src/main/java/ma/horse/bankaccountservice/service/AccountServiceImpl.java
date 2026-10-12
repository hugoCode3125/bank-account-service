package ma.horse.bankaccountservice.service;

import ma.horse.bankaccountservice.dtos.BankAccountRequestDTO;
import ma.horse.bankaccountservice.dtos.BankAccountResponseDTO;
import ma.horse.bankaccountservice.entities.BankAccount;
import ma.horse.bankaccountservice.mappers.AccountMapper;
import ma.horse.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO dto) {
        BankAccount account = accountMapper.fromBankAccountRequest(dto);
        BankAccount saved= bankAccountRepository.save(account);

        BankAccountResponseDTO responseDTO= accountMapper.fromBankAccount(saved);
        return responseDTO;
    }
}
