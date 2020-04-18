package cs5200_spring2020.demo.controller;

import cs5200_spring2020.demo.domain.Customer;
import cs5200_spring2020.demo.domain.User;
import cs5200_spring2020.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customer/create/bob")
    public Customer createBob(){
        Customer bob = new Customer(
                "bob",
                "bob",
                "bob@husky.neu.edu",
                "bob",
                null,
                "33333333",
                User.Role.Customer,
                10000,
                Customer.CarType.HatchBack
        );
        customerRepository.save(bob);
        return bob;
    }

    @GetMapping("customer/{cid}/update/{budget}")
    public Customer updateCustomerRole(
            @PathVariable("cid") Integer customerId,
            @PathVariable("budget") Integer customerBudget
    ){
        Customer customer = customerRepository.findCustomerById(customerId);
        customer.setBudget(customerBudget);
        customerRepository.save(customer);
        return customer;
    }

    @GetMapping("customer/{cid}/update/{role}")
    public Customer updateCustomerRole(
            @PathVariable("cid") Integer customerId,
            @PathVariable("role") User.Role customerRole
    ){
        Customer customer = customerRepository.findCustomerById(customerId);
        customer.setRole(customerRole);
        customerRepository.save(customer);
        return customer;
    }

    @GetMapping("/customer")
    public List<Customer> findAllCustomer(){
        return customerRepository.findAllCustomers();
    }

    @GetMapping("/customer/{cid}")
    public Customer findCustomerById(@PathVariable("cid") Integer cid){
        return customerRepository.findCustomerById(cid);
    }

    @GetMapping("/customer/delete")
    public void deleteAllCustomers(){
        customerRepository.deleteAllCustomers();
    }

    @GetMapping("/customer/delete/{cid}")
    public void deleteCustomerById(@PathVariable("cid") Integer cid){
        customerRepository.deleteCustomerById(cid);
    }
}
