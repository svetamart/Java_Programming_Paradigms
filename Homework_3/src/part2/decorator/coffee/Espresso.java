package part2.decorator.coffee;

public class Espresso implements iCoffee{
    @Override
    public double cost() {
        return 70.0;
    }
}
