package ma.horse.bankaccountservice.repositories;

import ma.horse.bankaccountservice.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
