package br.com.api.services;

import br.com.api.entity.Customer;
import br.com.api.infrastructure.exceptions.EntityNotFoundException;
import br.com.api.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;


    public Customer findById(final Long id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer Not Found!"));
    }

    public Customer save(final Customer customer){
        return repository.save(customer);
    }

    public Customer update(final Customer customerRequest){
        Customer customer = findById(customerRequest.getId());
        BeanUtils.copyProperties(customerRequest, customer);
        return repository.save(customerRequest);
    }

    public Customer delete(final Long id){
        Customer customer = findById(id);
        repository.delete(customer);
        return customer;
    }
    public List<Customer> findAll(){
        return repository.findAll();
    }
}
