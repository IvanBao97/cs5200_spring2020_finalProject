package com.neu.cs5200.buycar.controller;

import com.neu.cs5200.buycar.domain.CarModel;
import com.neu.cs5200.buycar.domain.Maker;
import com.neu.cs5200.buycar.repository.CarModelRepository;
import com.neu.cs5200.buycar.repository.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import cs5200_spring2020.demo.domain.*;

@RestController
public class MakerController {
    @Autowired
    MakerRepository makerRepository;

    @Autowired
    CarModelRepository carModelRepository;

    // Create Maker
    @PostMapping("/api/maker")
    public Maker createMaker
    (@RequestBody Maker maker) {
        return makerRepository.save(maker);
    }

    // Update Maker
    @PutMapping("/api/maker/{id}")
    public Maker updateMakerById(@PathVariable("id") int id, @RequestBody Maker maker_new) {
        Maker maker = makerRepository.findMakerById(id);
        if (maker_new.getName() != null)
            maker.setName(maker_new.getName());
        if (maker_new.getCountry() != null)
            maker.setCountry(maker_new.getCountry());
        if (maker_new.getCarModels() != null)
            maker.setCarModels(maker_new.getCarModels());
        return makerRepository.save(maker);
    }

    // Deal with the relationship between domain objects
    // Update Maker's Carmodel
    @PutMapping("/api/maker/{mid}/carmodel/{cid}")
    public Maker setMakerCarModel(@PathVariable("mid") int mid, @PathVariable("cid") int cid) {
        Maker maker = makerRepository.findMakerById(mid);
        CarModel carModel = carModelRepository.findCarModelById(cid);
        maker.getCarModels().add(carModel);
        carModel.setMaker(maker);
        carModelRepository.save(carModel);
        return makerRepository.save(maker);
    }

    // Delete Maker's Carmodel
    @PutMapping("/api/maker/{mid}/carmodel/{cid}/delete_car_model")
    public Maker deleteCarModelFromMaker(@PathVariable("mid") int mid, @PathVariable("cid") int cid) {
        CarModel carModel = carModelRepository.findCarModelById(cid);
        carModel.setMaker(null);
        carModelRepository.save(carModel);
        return makerRepository.findMakerById(mid);
    }

    // Find All Makers
    @GetMapping("/api/maker")
    public List<Maker> findAllMakers() {
        return makerRepository.findAllMakers();
    }

    // Find Maker By Id
    @GetMapping("/api/maker/id/{id}")
    public Maker findMakerById(@PathVariable("id") int id) {
        return makerRepository.findMakerById(id);
    }

    // Find Maker By Name
    @GetMapping("/api/maker/name/{name}")
    public List<Maker> findAllMakersByName(@PathVariable("name") String name) {
        return makerRepository.findAllMakersByName(name);
    }

    // Find Maker By Country
    @GetMapping("/api/maker/country/{country}")
    public List<Maker> findAllMakersByCountry(@PathVariable("country") String country) {
        return makerRepository.findAllMakersByCountry(country);
    }

    // Delete Maker By Id
    @DeleteMapping("/api/maker/{id}")
    public void deleteMakerById(@PathVariable("id") int id) {
        makerRepository.deleteMakerById(id);
    }

    // Delete All Makers
    @DeleteMapping("/api/maker")
    public void deleteAllMakers() {
        makerRepository.deleteAllMaker();
    }
}
