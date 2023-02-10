package hello.core.customer;

public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void join(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findCustomer(Long id) {
        return customerRepository.findById(id);
    }

    //테스트 용도
    public CustomerRepository getCustomerRepository(){
        return customerRepository;
    }
}
