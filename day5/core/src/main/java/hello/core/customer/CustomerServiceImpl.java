package hello.core.customer;

public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository = new MemoryCustomerRepository();

    @Override
    public void join(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findCustomer(Long id) {
        return customerRepository.findById(id);
    }
}
