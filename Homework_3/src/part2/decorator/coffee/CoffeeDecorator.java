package part2.decorator.coffee;

public abstract class CoffeeDecorator implements iCoffee {
    protected iCoffee coffee;

    public CoffeeDecorator(iCoffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double cost() {
        return coffee.cost();
    }
}
