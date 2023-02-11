package hello.core.customer;

public interface CustomerRepository {
    void save(Customer customer);

    Customer findById(Long id);
}