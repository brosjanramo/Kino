package Gruppe10.Model;

import java.time.LocalDate;

public class Manager extends Person{
    private String title;

    public Manager(String title,String name, int id, LocalDate birthDate, String email, int phone) {
        super(name, id, birthDate, email, phone);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
