package ma.horse.bankaccountservice.repositories;

import ma.horse.bankaccountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
