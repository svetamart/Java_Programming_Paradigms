package part2.decorator;

import part2.decorator.coffee.Espresso;
import part2.decorator.coffee.Milk;
import part2.decorator.coffee.Sugar;
import part2.decorator.coffee.iCoffee;

public class Main {
    public static void main(String[] args) {
        iCoffee espresso = new Espresso();
        System.out.println("Стоимость эспрессо: " + espresso.cost() + " рублей");

        iCoffee coffeeWithSugar = new Sugar(espresso);
        System.out.println("Стоимость эспрессо с сахаром: " + coffeeWithSugar.cost() + " рублей");

        iCoffee coffeeWithMilk = new Milk(espresso);
        System.out.println("Стоимость эспрессо с молоком: " + coffeeWithMilk.cost() + " рублей");

        iCoffee coffeeWithMilkAndSugar = new Milk(new Sugar(espresso));
        System.out.println("Стоимость эспрессо с сахаром и молоком: " + coffeeWithMilkAndSugar.cost() + " рублей");
    }
}
