/*
ООП Концепции:
Создайте класс Person, который имеет атрибуты name, age и метод introduce(), выводящий информацию о человеке.
Создайте несколько объектов этого класса и вызовите метод introduce() для каждого из них.
 */

package part1.generalConcepts;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Аня", 21);
        Person person2 = new Person("Денис", 32);
        Person person3 = new Person("Мария", 45);
        Person person4 = new Person("Саша", 12);

        person1.introduce();
        person2.introduce();
        person3.introduce();
        person4.introduce();

    }
}
