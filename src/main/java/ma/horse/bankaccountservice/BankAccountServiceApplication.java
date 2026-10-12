package ma.horse.bankaccountservice;

import ma.horse.bankaccountservice.entities.BankAccount;
import ma.horse.bankaccountservice.entities.Customer;
import ma.horse.bankaccountservice.enums.AccountType;
import ma.horse.bankaccountservice.repositories.BankAccountRepository;
import ma.horse.bankaccountservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start (BankAccountRepository repository, CustomerRepository customerRepository) {
        return args -> {

            Stream.of("Mohamed","hugo","Fawzi").forEach(c->{
                Customer customer = Customer.builder()
                        .name(c)
                        .build();
                customerRepository.save(customer);
            });

            customerRepository.findAll().forEach(customer -> {
                for (int i=0; i<5; i++) {
                    BankAccount account = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                            .balance(10000+Math.random()*90000)
                            .currency("MAD")
                            .createdAt(new Date())
                            .customer(customer)
                            .build();
                    repository.save(account);
                }
            });

        };
    }
}
