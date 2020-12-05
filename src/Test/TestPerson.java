
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;


public class TestPerson {


    private Person faker;
    private Person t1;
    private Person doubleLift;
    private Person sneaky;
    ArrayList<Person> persons;

    @Before
    public void setup(){
        faker = new Person("Faker", LocalDate.of(1996, 4, 24), Person.Sex.MALE, "FakerBaby@gmail.com");
        t1 = new Person("Tyer1", LocalDate.of(1990, 4, 20), Person.Sex.MALE, "DiscountCodeAlpha.@gmail.com");
        doubleLift = new Person("DoubleLift", LocalDate.of(2000, 12, 2),
                Person.Sex.MALE, "ADC-Sucks-in-s10@gmail.com");
        sneaky = new Person("Sneaky", LocalDate.of(1995, 4, 20), Person.Sex.FEMALE, "NotATrap@gmail.com");

        persons = new ArrayList<>(Arrays.asList(faker, t1, doubleLift));

    }

    @Test
    public void testAgeFaker(){
        Integer expected = 24;
        Integer actual = faker.getAge();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testAgeT1(){
        Integer expected = 30;
        Integer actual = t1.getAge();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testAgeDoubleLift(){
        Integer expected = 20;
        Integer actual = doubleLift.getAge();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testPrintPerson(){
        faker.printPerson();
    }

    @Test
    public void testPrintPersonOlderThan(){
        Person.printPersonsOlderThan(persons, 21);
    }

    @Test
    public void testPringPersonAgeRange(){
        Person.printPersonsWithinAgeRange(persons, 10, 29);
    }

    @Test //Should return only men, not stinky janna players
    public void testAnon(){
        Person.printPersons(persons, Person.Sex.FEMALE);
    }
}
