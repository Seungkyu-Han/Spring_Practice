package hello.core.customer;

public interface CustomerService {
    void join(Customer customer);

    Customer findCustomer(Long id);
}