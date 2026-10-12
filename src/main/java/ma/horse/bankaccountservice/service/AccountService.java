package ma.horse.bankaccountservice.service;

import ma.horse.bankaccountservice.dtos.BankAccountRequestDTO;
import ma.horse.bankaccountservice.dtos.BankAccountResponseDTO;

public interface AccountService {
    public BankAccountResponseDTO addAccount (BankAccountRequestDTO dto);
}
