package cs5200_spring2020.demo.controller;

import cs5200_spring2020.demo.domain.Customer;
import cs5200_spring2020.demo.domain.Message;
import cs5200_spring2020.demo.domain.Salesman;
import cs5200_spring2020.demo.repository.CustomerRepository;
import cs5200_spring2020.demo.repository.MessageRepository;
import cs5200_spring2020.demo.repository.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalesmanController {
    @Autowired
    SalesmanRepository salesmanRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    MessageRepository messageRepository;

    //Create Salesman
    @PostMapping("/api/salesman")
    public Salesman createSalesman(@RequestBody Salesman salesman) {
        return salesmanRepository.save(salesman);
    }

    //Update Salesman
    @PutMapping("/api/salesman/{sid}")
    public Salesman updateSalesman(
            @PathVariable("sid") int id,
            @RequestBody Salesman newSalesman) {
        Salesman salesman = salesmanRepository.findSalesmanById(id);
        if(newSalesman.getUsername() != null){
            salesman.setUsername(newSalesman.getUsername());
        }
        if(newSalesman.getPassword() != null){
            salesman.setPassword(newSalesman.getPassword());
        }
        if(newSalesman.getEmail() != null){
            salesman.setEmail(newSalesman.getEmail());
        }
        if (newSalesman.getName() != null){
            salesman.setName(newSalesman.getName());
        }
        if(newSalesman.getPhone() != null){
            salesman.setPhone(newSalesman.getPhone());
        }
        if(newSalesman.getEnable() != null){
            salesman.setEnable(newSalesman.getEnable());
        }
        if (newSalesman.getRole() != null){
            salesman.setRole(newSalesman.getRole());
        }
        if(newSalesman.getFoundYear() != 0){
            salesman.setFoundYear(newSalesman.getFoundYear());
        }

        return salesmanRepository.save(salesman);
    }

    //SalesmanSendMessageToCustomer
    @PutMapping("/api/salesman/{sid}/message/{mid}/customer/{cid}")
    public void customerSendMessageToSalesman(
            @PathVariable("sid") Integer sid,
            @PathVariable("mid") Integer mid,
            @PathVariable("cid") Integer cid
    ){
        Salesman salesman = salesmanRepository.findSalesmanById(sid);
        Message message = messageRepository.findMessageById(mid);
        Customer customer = customerRepository.findCustomerById(cid);
        message.setCustomer(customer);
        message.setSalesman(salesman);
        messageRepository.save(message);
    }

    //Set s1 as s2's supervisor(self-reference)
    @PutMapping("/api/salesman/{sid1}/salesman/{sid2}")
    public Salesman setSupervisor(
            @PathVariable("sid1") Integer sid1,
            @PathVariable("sid2") Integer sid2
    ){
        Salesman s1 = salesmanRepository.findSalesmanById(sid1);
        Salesman s2 = salesmanRepository.findSalesmanById(sid2);
        if(!s1.getSubordinates().contains(s2)){
            s1.getSubordinates().add(s2);
            s2.setSupervisor(s1);
        }
        return salesmanRepository.save(s1);
    }

    //FindAllSalesmen
    @GetMapping("/api/salesman")
    public List<Salesman> findAllSalesmen(){
        return salesmanRepository.findAllSalesmen();
    }

    //FindSalesmanById
    @GetMapping("/api/salesman/id/{sid}")
    public Salesman findSalesmanById(
            @PathVariable("sid") Integer sid
    ){
        return salesmanRepository.findSalesmanById(sid);
    }

    //FindSalesmanByUsername
    @GetMapping("/api/salesman/username/{username}")
    public List<Salesman> findSalesmanByUsername(
            @PathVariable(name="username") String username
    ){
        if(username != null) {
            return salesmanRepository.findSalesmanByUsername(username);
        }
        return salesmanRepository.findAllSalesmen();
    }

    //DeleteAllSalesmen
    @DeleteMapping("/api/salesman")
    public void deleteAllSalesmen(){
        salesmanRepository.deleteAllSalesmen();
    }

    //DeleteSalesmanById
    @DeleteMapping("/api/salesman/{sid}")
    public void deleteSalesmanById(
            @PathVariable("sid") Integer sid
    ){
        salesmanRepository.deleteSalesmanById(sid);
    }

    //
}
