

public class CheckGender implements CheckPerson{

    @Override
    public boolean test(Person p, Person.Sex sex) {
        return p.getGender().equals(sex);
    }
}
