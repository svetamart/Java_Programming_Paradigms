package part2.factoryMethod.shapes;

import part2.factoryMethod.ShapeFactory;
import part2.factoryMethod.iShape;

public class SquareFactory extends ShapeFactory {
    private static int squareCounter = 0;
    @Override
    public iShape create() {
        iShape shape = new Square();
        shape.setName("Квадрат_" + (++squareCounter));
        return shape;
    }
}
