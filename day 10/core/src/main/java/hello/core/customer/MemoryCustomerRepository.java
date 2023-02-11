package hello.core.customer;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryCustomerRepository implements CustomerRepository{

    private static Map<Long, Customer> store = new HashMap<>();

    @Override
    public void save(Customer customer) {
        store.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(Long id) {
        return store.get(id);
    }
}
