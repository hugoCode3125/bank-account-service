package ma.horse.bankaccountservice.web;

import ma.horse.bankaccountservice.dtos.BankAccountRequestDTO;
import ma.horse.bankaccountservice.dtos.BankAccountResponseDTO;
import ma.horse.bankaccountservice.entities.BankAccount;
import ma.horse.bankaccountservice.repositories.BankAccountRepository;
import ma.horse.bankaccountservice.service.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphqlController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;

    public BankAccountGraphqlController(BankAccountRepository bankAccountRepository, AccountService accountService) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
    }

    @QueryMapping
    public List<BankAccount> accountsLists() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount accountById(@Argument String id) {
        return bankAccountRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public BankAccountResponseDTO addBankAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public Boolean delete(@Argument String id){
        bankAccountRepository.deleteById(id);
        return true;
    }
}
