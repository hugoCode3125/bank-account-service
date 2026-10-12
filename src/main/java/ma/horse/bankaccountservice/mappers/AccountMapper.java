package ma.horse.bankaccountservice.mappers;

import ma.horse.bankaccountservice.dtos.BankAccountRequestDTO;
import ma.horse.bankaccountservice.dtos.BankAccountResponseDTO;
import ma.horse.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
public class AccountMapper {

    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }

    public BankAccount fromBankAccountRequest(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountRequestDTO, bankAccount);
        return bankAccount;
    }

}
