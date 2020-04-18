package cs5200_spring2020.demo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer extends User{
    public enum CarType {SUV, Sadam, HatchBack, Wagon, Van}
    private int budget;

    @Enumerated(EnumType.STRING)
    private CarType preferType;

    @OneToMany(mappedBy = "customer")
    private List<Message> messages;

    public Customer() { }

    public Customer(String username, String password, String email, String name, Boolean enable, String phone, Role role, int budget, CarType preferType) {
        super(username, password, email, name, enable, phone, role);
        this.budget = budget;
        this.preferType = preferType;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public CarType getPreferType() {
        return preferType;
    }

    public void setPreferType(CarType preferType) {
        this.preferType = preferType;
    }
}
