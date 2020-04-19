package com.neu.cs5200.buycar.controller;

import com.neu.cs5200.buycar.domain.Customer;
import com.neu.cs5200.buycar.domain.Message;
import com.neu.cs5200.buycar.domain.Salesman;
import com.neu.cs5200.buycar.repository.CustomerRepository;
import com.neu.cs5200.buycar.repository.MessageRepository;
import com.neu.cs5200.buycar.repository.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    SalesmanRepository salesmanRepository;
    @Autowired
    MessageRepository messageRepository;

    //Create Salesman
    @PostMapping("/api/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    //Update Salesman
    @PutMapping("/api/customer/{sid}")
    public Customer UpdateCustomer(
            @PathVariable("sid") int id,
            @RequestBody Customer newCustomer) {
        Customer customer = customerRepository.findCustomerById(id);
        if(newCustomer.getName() != null){
            customer.setUsername(newCustomer.getUsername());
        }
        if(newCustomer.getPassword() != null){
            customer.setPassword(newCustomer.getPassword());
        }
        if(newCustomer.getEmail() != null){
            customer.setEmail(newCustomer.getEmail());
        }
        if(newCustomer.getName() != null){
            customer.setName(newCustomer.getName());
        }
        if(newCustomer.getPhone() != null){
            customer.setPhone(newCustomer.getPhone());
        }
        if(newCustomer.getEnable() != null){
            customer.setEnable(newCustomer.getEnable());
        }
        if(newCustomer.getRole() != null){
            customer.setRole(newCustomer.getRole());
        }
        if(newCustomer.getBudget() != 0){
            customer.setBudget(newCustomer.getBudget());
        }
        if(newCustomer.getPreferType() != null){
            customer.setPreferType(newCustomer.getPreferType());
        }

        return customerRepository.save(customer);
    }

    //CustomerSendMessageCustomerSendMessageToSalesman
    @PutMapping("/api/customer/{cid}/message/{mid}/salesman/{sid}")
    public void customerSendMessageToSalesman(
            @PathVariable("cid") Integer cid,
            @PathVariable("mid") Integer mid,
            @PathVariable("sid") Integer sid
    ){
        Customer customer = customerRepository.findCustomerById(cid);
        Message message = messageRepository.findMessageById(mid);
        Salesman salesman = salesmanRepository.findSalesmanById(sid);
        message.setSalesman(salesman);
        message.setCustomer(customer);
        messageRepository.save(message);
    }

    //FindAllCustomers
    @GetMapping("/api/customer")
    public List<Customer> findAllCustomer(){
        return customerRepository.findAllCustomers();
    }

    //FindCustomerById
    @GetMapping("/api/customer/id/{cid}")
    public Customer findCustomerById(@PathVariable("cid") Integer cid){
        return customerRepository.findCustomerById(cid);
    }

    //FindCustomerByUsername
    @GetMapping("/api/customer/username/{username}")
    public List<Customer> findCustomerByUsername(
            @PathVariable(name="username") String username
    ){
        if(username != null){
            return customerRepository.findCustomerByUsername(username);
        }
        return customerRepository.findAllCustomers();
    }

    //DeleteAllCustomers
    @DeleteMapping("/api/customer")
    public void deleteAllCustomers(){
        customerRepository.deleteAllCustomers();
    }

    //DeleteCustomerById
    @DeleteMapping("/api/customer/{cid}")
    public void deleteCustomerById(@PathVariable("cid") Integer cid){
        customerRepository.deleteCustomerById(cid);
    }



}
