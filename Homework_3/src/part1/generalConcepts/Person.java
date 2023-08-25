package part1.generalConcepts;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        if (this.age >= 11 && this.age <= 19) {
            System.out.printf("Привет! Меня зовут %s и мне %d лет.\n", this.name, this.age);
        } else {
            int lastDigit = this.age % 10;
            if (lastDigit == 1) {
                System.out.printf("Привет! Меня зовут %s и мне %d год.\n", this.name, this.age);
            } else if (lastDigit >= 2 && lastDigit <= 4) {
                System.out.printf("Привет! Меня зовут %s и мне %d года.\n", this.name, this.age);
            } else {
                System.out.printf("Привет! Меня зовут %s и мне %d лет.\n", this.name, this.age);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
