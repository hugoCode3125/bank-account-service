package ma.horse.bankaccountservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.horse.bankaccountservice.enums.AccountType;

import java.util.Date;
@Data @Builder @NoArgsConstructor
@AllArgsConstructor
public class BankAccountResponseDTO {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
