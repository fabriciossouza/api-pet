package br.com.api.endpoints;

import br.com.api.endpoints.validator.CustomerValidator;
import br.com.api.entity.Customer;
import br.com.api.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rs/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerEndpoint {

    private CustomerService service;
    private CustomerValidator validator;

    @Autowired
    public CustomerEndpoint(final CustomerService service, final CustomerValidator validator){
        this.service = service;
        this.validator = validator;
    }

    @GetMapping
    public List<Customer> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Customer findById(@PathVariable final Long id){
        return service.findById(id);
    }

    @PostMapping
    public Customer save(@RequestBody final Customer customer){
        validator.validate(customer);
        return service.save(customer);
    }

    @PutMapping(value = "/{id}")
    public Customer update(@PathVariable final Long id, @RequestBody final Customer customer){
        customer.setId(id);
        return service.update(customer);
    }

    @DeleteMapping(value = "/{id}")
    public Customer delete(@PathVariable final Long id){
        return service.delete(id);
    }
}
