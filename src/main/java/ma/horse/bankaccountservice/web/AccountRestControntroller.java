package ma.horse.bankaccountservice.web;

import ma.horse.bankaccountservice.dtos.BankAccountRequestDTO;
import ma.horse.bankaccountservice.dtos.BankAccountResponseDTO;
import ma.horse.bankaccountservice.entities.BankAccount;
import ma.horse.bankaccountservice.repositories.BankAccountRepository;
import ma.horse.bankaccountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AccountRestControntroller {
    private BankAccountRepository repository;

    private AccountService accountService;

    public AccountRestControntroller(BankAccountRepository repository, AccountService accountService) {
        this.repository = repository;
        this.accountService = accountService;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> getBankAccounts() {
        return repository.findAll();
    }

    @GetMapping("/bankAccount/{id}")
    public BankAccount getBankAccountById(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/bankAccount")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO) {
        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccount/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount) {

        BankAccount account = repository.findById(id).orElse(null);
        if (account.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if (account.getType()!=null) account.setType(bankAccount.getType());
        //pareil pour le reste des attributs
        return repository.save(account);
    }

    @DeleteMapping("bankAccount/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }
}
