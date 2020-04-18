package cs5200_spring2020.demo.controller;

import cs5200_spring2020.demo.domain.Salesman;
import cs5200_spring2020.demo.domain.User;
import cs5200_spring2020.demo.repository.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalesmanController {
    @Autowired
    SalesmanRepository salesmanRepository;

    @GetMapping("/salesman/create/alice")
    public Salesman createSalesman(){
        Salesman alice = new Salesman(
                "alice",
                "alice",
                "alice@husky.neu.edu",
                "alice",
                null,
                "22222222",
                User.Role.Salesman,
                10000
        );
        salesmanRepository.save(alice);
        return alice;
    }

    @GetMapping("salesman/{sid}/update/{found}")
    public Salesman updateCustomerRole(
            @PathVariable("sid") Integer salesmanId,
            @PathVariable("found") Integer foundYear
    ){
        Salesman salesman = salesmanRepository.findSalesmanById(salesmanId);
        salesman.setFoundYear(foundYear);
        salesmanRepository.save(salesman);
        return salesman;
    }

    @GetMapping("salesman/{sid}/update/{role}")
    public Salesman updateCustomerRole(
            @PathVariable("sid") Integer salesmanId,
            @PathVariable("role") User.Role salesmanRole
    ){
        Salesman salesman = salesmanRepository.findSalesmanById(salesmanId);
        salesman.setRole(salesmanRole);
        salesmanRepository.save(salesman);
        return salesman;
    }

    @GetMapping("/salesman")
    public List<Salesman> findAllSalesmen(){
        return salesmanRepository.findAllSalesmen();
    }

    @GetMapping("/salesman/{sid}")
    public Salesman findSalesmanById(@PathVariable("sid") Integer sid){
        return salesmanRepository.findSalesmanById(sid);
    }

    @GetMapping("/salesman/delete")
    public void deleteAllSalesmen(){
        salesmanRepository.deleteAllSalesmen();
    }

    @GetMapping("/salesman/delete/{sid}")
    public void deleteSalesmanById(@PathVariable("sid") Integer sid){
        salesmanRepository.deleteSalesmanById(sid);
    }
}
