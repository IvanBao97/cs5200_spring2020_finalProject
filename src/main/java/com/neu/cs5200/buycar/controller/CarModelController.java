package com.neu.cs5200.buycar.controller;

import com.neu.cs5200.buycar.domain.CarModel;
import com.neu.cs5200.buycar.domain.Customer;
import com.neu.cs5200.buycar.domain.Maker;
import com.neu.cs5200.buycar.domain.Salesman;
import com.neu.cs5200.buycar.repository.CarModelRepository;
import com.neu.cs5200.buycar.repository.MakerRepository;
import com.neu.cs5200.buycar.repository.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarModelController {
    @Autowired
    CarModelRepository carModelRepository;

    @Autowired
    MakerRepository makerRepository;

    @Autowired
    SalesmanRepository salesmanRepository;

    //Create Carmodel
    @PostMapping("/api/carmodel")
    public CarModel createCarModel
    (@RequestBody CarModel carmodel) {
        return carModelRepository.save(carmodel);
    }

    //Update Carmodel
    @PutMapping("/api/carmodel/{id}")
    public CarModel updateCarModelById (@PathVariable("id") int id, @RequestBody CarModel carmodel_new){
        CarModel carmodel = carModelRepository.findCarModelById(id);
        if (carmodel_new.getName()!= null)
            carmodel.setName(carmodel_new.getName());
        if (carmodel_new.getYear()!= 0)
            carmodel.setYear(carmodel_new.getYear());
        if (carmodel_new.getColor()!= null)
            carmodel.setColor(carmodel_new.getColor());
        if (carmodel_new.getVIN()!= null)
            carmodel.setVIN(carmodel_new.getVIN());
        if (carmodel_new.getType()!= null)
            carmodel.setType(carmodel_new.getType());
        if (carmodel_new.getMaker()!= null)
            carmodel.setMaker(carmodel_new.getMaker());
        return carModelRepository.save(carmodel);
    }

    // Deal with the relationship between domain objects
    // Update Carmodel maker
    @PutMapping ("/api/carmodel/{cid}/maker/{mid}")
    public CarModel setCarModelMaker (@PathVariable("cid") int cid, @PathVariable("mid") int mid){
        Maker maker = makerRepository.findMakerById(mid);
        CarModel carModel = carModelRepository.findCarModelById(cid);
        carModel.setMaker(maker);
//        maker.getCarModels().add(carModel);
//        makerRepository.save(maker);
        return carModelRepository.save(carModel);
    }

    // Delete Carmodel maker
    @PutMapping ("/api/carmodel/{cid}/delete_maker")
    public CarModel deleteMakerFromCarModel (@PathVariable("cid") int cid){
        CarModel carModel = carModelRepository.findCarModelById(cid);
        carModel.setMaker(null);
        return carModelRepository.save(carModel);
    }

    // Update Carmodel salesman
    @PutMapping("/api/carmodel/{cid}/salesman/{sid}")
    public CarModel setCarModelSalesman(@PathVariable("cid") int cid, @PathVariable("sid") int sid) {
        CarModel carModel = carModelRepository.findCarModelById(cid);
        Salesman salesman = salesmanRepository.findSalesmanById(sid);
        carModel.getSalesmen().add(salesman);
        salesman.getCarModels().add(carModel);
        salesmanRepository.save(salesman);
        return carModelRepository.save(carModel);
    }

    // Delete Carmodel salesman
    @PutMapping("/api/carmodel/{cid}/salesman/{sid}/delete_salesman")
    public CarModel deleteCarModelFromSalesman(@PathVariable("cid") int cid, @PathVariable("sid") int sid) {
        CarModel carModel = carModelRepository.findCarModelById(cid);
        Salesman salesman = salesmanRepository.findSalesmanById(sid);
        carModel.getSalesmen().remove(salesman);
        salesman.getCarModels().remove(carModel);
        salesmanRepository.save(salesman);
        return carModelRepository.save(carModel);
    }

    // Find all Carmodels
    @GetMapping("/api/carmodel")
    public List<CarModel> findAllModels() {
        return carModelRepository.findAllCarModels();
    }

    // Find Carmodels by Id
    @GetMapping("/api/carmodel/id/{id}")
    public CarModel findCarModelsById(@PathVariable("id") int id) {
        return carModelRepository.findCarModelById(id);
    }

    // Find Carmodels by Vin
    @GetMapping("/api/carmodel/vin/{vin}")
    public CarModel findCarModelsByVin(@PathVariable("vin") String vin) {
        return carModelRepository.findCarModelByVin(vin);
    }

    // Find Carmodels by Name
    @GetMapping("/api/carmodel/name/{name}")
    public List<CarModel> findAllCarModelsByName(@PathVariable("name") String name) {
        return carModelRepository.findAllCarModelsByName(name);
    }

    // Find Carmodels by Year
    @GetMapping("/api/carmodel/year/{year}")
    public List<CarModel> findAllCarModelsByYear(@PathVariable("year") int year) {
        return carModelRepository.findAllCarModelsByYear(year);
    }

    // Find Carmodels by Color
    @GetMapping("/api/carmodel/color/{color}")
    public List<CarModel> findAllCarModelsByColor(@PathVariable("color") String color) {
        return carModelRepository.findAllCarModelsByColor(color);
    }

    // Find Carmodels by Type
    @GetMapping("/api/carmodel/type/{type}")
    public List<CarModel> findAllCarModelsByType(@PathVariable("type") Customer.CarType type) {
        return carModelRepository.findAllCarModelsByType(type);
    }

    // Delete Carmodel by Id
    @DeleteMapping(value = "/api/carmodel/{id}")
    public void deleteCarModelById(@PathVariable("id") int id) {
        carModelRepository.deleteCarModelById(id);
    }

    // Delete All Carmodel
    @DeleteMapping("/api/carmodel")
    public void deleteAllCarModels (){
        carModelRepository.deleteAllCarModel();
    }
}
