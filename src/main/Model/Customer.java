package Model;

import java.time.LocalDate;

public class Customer extends Person{
    private String position;

    public Customer(String name, int id, LocalDate birthDate, String email, int phone, String position) {
        super(name, id, birthDate, email, phone);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
