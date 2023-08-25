package part2.decorator.coffee;

public class Sugar extends CoffeeDecorator {
    public Sugar(iCoffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost() + 10.0;
    }
}
