package part2.decorator.coffee;

public class Milk extends CoffeeDecorator {
    public Milk(iCoffee coffee) {
        super(coffee);
    }
    @Override
    public double cost() {
        return super.cost() + 20.0;
    }
}
