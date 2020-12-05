import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person implements CheckPerson{

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        LocalDate now = LocalDate.now();
        Period difference = Period.between(birthday, now);
        return difference.getYears();
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public boolean test(Person p) {
        return false;
    }

    public void printPerson() {
        String output = "Name: "+this.name+" Birthdate: "+this.birthday+" Gender: "+this.gender+" Email: "+emailAddress;
        System.out.println(output);
    }

    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void lambda() {
        Person faker = new Person("Faker", LocalDate.of(1996, 4, 24), Person.Sex.MALE, "FakerBaby@gmail.com");
        Person t1 = new Person("Tyer1", LocalDate.of(1990, 4, 20), Person.Sex.MALE, "DiscountCodeAlpha.@gmail.com");
        Person doubleLift = new Person("DoubleLift", LocalDate.of(2000, 12, 2),
                Person.Sex.MALE, "ADC-Sucks-in-s10@gmail.com");
        Person support = new Person("JannaMain222", LocalDate.of(1990, 3, 20), Sex.FEMALE, "JannaRules@Gmail.com");
        ArrayList<Person> persons = new ArrayList<>(Arrays.asList(faker, t1, doubleLift, support));
        printPersons(persons, person -> person.getGender().equals(Sex.MALE));
    }
}