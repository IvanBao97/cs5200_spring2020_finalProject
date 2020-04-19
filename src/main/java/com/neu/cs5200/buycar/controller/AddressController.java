package com.neu.cs5200.buycar.controller;

import com.neu.cs5200.buycar.domain.Address;
import com.neu.cs5200.buycar.domain.Salesman;
import com.neu.cs5200.buycar.repository.AddressRepository;
import com.neu.cs5200.buycar.repository.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    SalesmanRepository salesmanRepository;

    //CreateAddress
    @PostMapping("/api/address")
    public Address createAddress
    (@RequestBody Address address) {
        return addressRepository.save(address);
    }

    //UpdateAddress
    @PutMapping ("/api/address/{id}")
    public Address updateAddressById (@PathVariable("id") int id, @RequestBody Address address_new){
        Address address = addressRepository.findAddressById(id);
        if (address_new.getStreet() != null)
            address.setStreet(address_new.getStreet());
        if (address_new.getCity() != null)
            address.setCity(address_new.getCity());
        if (address_new.getState() != null)
            address.setState(address_new.getState());
        if (address_new.getZipcode() != null)
            address.setZipcode(address_new.getZipcode());
        if (address_new.getSalesman() != null)
            address.setSalesman(address_new.getSalesman());
        return addressRepository.save(address);
    }

    // Deal with the relationship between domain objects
    @PutMapping ("/api/address/{aid}/salesman/{sid}")
    public Address setSalesmanAddress (@PathVariable("aid") int aid, @PathVariable("sid") int sid){
        Salesman salesman = salesmanRepository.findSalesmanById(sid);
        Address address = addressRepository.findAddressById(aid);
        address.setSalesman(salesman);
        salesman.setAddress(address);
        salesmanRepository.save(salesman);
        return addressRepository.save(address);
    }

    //FindAllAddresses
    @GetMapping("/api/address")
    public List<Address> findAllAddresses() {
        return addressRepository.findAllAddresses();
    }

    //FindAddressById
    @GetMapping("/api/address/id/{id}")
    public Address findAddressById(@PathVariable("id") int id) {
        return addressRepository.findAddressById(id);
    }

    //FindAddressByStreet
    @GetMapping("/api/address/street/{street}")
    public List<Address> findAllAddresssByStreet(@PathVariable("street") String street) {
        return addressRepository.findAllAddressesByStreet(street);
    }

    //FindAddressByCity
    @GetMapping("/api/address/city/{city}")
    public List<Address> findAllAddresssByCity(@PathVariable("city") String city) {
        return addressRepository.findAllAddressesByCity(city);
    }

    //FindAddressByState
    @GetMapping("/api/address/state/{state}")
    public List<Address> findAllAddresssByState(@PathVariable("state") String state) {
        return addressRepository.findAllAddressesByState(state);
    }

    //FindAddressByZipcode
    @GetMapping("/api/address/zipcode/{zipcode}")
    public List<Address> findAllAddresssByZipcode(@PathVariable("zipcode") String zipcode) {
        return addressRepository.findAllAddressesByZipcode(zipcode);
    }


    //DeleteAddressById
    @DeleteMapping("/api/address/{id}")
    public void deleteAddressById(@PathVariable("id") int id) {
        addressRepository.deleteAddressById(id);
    }

    //DeleteAllAddresses
    @DeleteMapping("/api/address")
    public void deleteAllAddresses (){
        addressRepository.deleteAllAddresses();
    }


}