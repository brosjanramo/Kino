import Gruppe10.Model.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class loginTest {
    @Test
    void loginTest(){
        Person john = new Person("John",1, LocalDate.of(1996,12,20),"john@email.com",46822493);
        ArrayList<Person> idListe = new ArrayList<Person>();
        idListe.add(john);
        assertEquals("1",Integer.toString(idListe.get(0).getId()));
    }

    @Test
    void wrongIdTest(){
        Person john = new Person("John",1, LocalDate.of(1996,12,20),"john@email.com",46822493);
        ArrayList<Person> idListe = new ArrayList<Person>();
        idListe.add(john);
        assertEquals("2",Integer.toString(idListe.get(0).getId()));
    }
}
