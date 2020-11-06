import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    @Test
    public void getNameTest(){
        Person person = new Person("Sam", "ACTIVE");
        assertEquals(person.getName(), "Sam");
    }

    @Test
    public void getStatusTest(){
        Person person = new Person("Sam", "ACTIVE");
        assertEquals(person.getStatus(), "ACTIVE");
    }

    @Test
    public void setStatusTest(){
        Person person = new Person("Sam", "ACTIVE");
        person.setStatus("DORMANT");
        assertEquals(person.getStatus(), "DORMANT");

    }

}
