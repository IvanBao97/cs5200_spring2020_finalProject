package cs5200_spring2020.demo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Salesman extends User {
    private int foundYear;
    //self-reference
    @ManyToOne
    private Salesman supervisor;
    @OneToMany(mappedBy="supervisor")
    private List<Salesman> subordinates ;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "salesman")
    private List<Message> messages;

    @ManyToMany
    @JoinTable(name = "salesman_carModel",joinColumns = @JoinColumn(name = "salesman_id"),
            inverseJoinColumns = @JoinColumn(name = "carModel_id"))
    private List<CarModel> carModels;

    public Salesman() { }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<CarModel> getCarModels() {
        return carModels;
    }

    public void setCarModels(List<CarModel> carModels) {
        this.carModels = carModels;
    }

    public int getFoundYear() {
        return foundYear;
    }

    public void setFoundYear(int foundYear) {
        this.foundYear = foundYear;
    }

    public Salesman getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Salesman supervisor) {
        this.supervisor = supervisor;
    }

    public List<Salesman> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Salesman> subordinates) {
        this.subordinates = subordinates;
    }
}