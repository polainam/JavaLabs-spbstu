package lab2;

import lab2.Annotations.ParameterNamesAnnotation;
import lab2.Annotations.RepeatingAnnotation;

public class Person {

    private String name;
    private int age;
    private String phoneNumber;

    public Person(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    @RepeatingAnnotation(numberOfRepetitions = 3)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //@RepeatingAnnotation(numberOfRepetitions = 4)
    private String editPhoneNumber() {
        return this.phoneNumber = this.phoneNumber.substring(0,1).replace('8','7')
                + this.phoneNumber.substring(1);
    }

    @RepeatingAnnotation(numberOfRepetitions = 2)
    @ParameterNamesAnnotation({"This year", "Address"})
    private int findOutYearOfBirth(Integer year, String address) {
        System.out.println(address);
        return year - this.age;
    }

    //@RepeatingAnnotation(numberOfRepetitions = 2)
    protected boolean isPhoneNumberValid() {
        return this.phoneNumber.length() == 11;
    }

    @RepeatingAnnotation(numberOfRepetitions = 1)
    @ParameterNamesAnnotation({"Last name"})
    protected String completeName(String lastName) {
        return this.name + " " + lastName;
    }

    @RepeatingAnnotation(numberOfRepetitions = 3)
    void someMethod() {
        System.out.println("default method");
    }
}
