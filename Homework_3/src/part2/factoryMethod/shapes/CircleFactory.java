package part2.factoryMethod.shapes;

import part2.factoryMethod.ShapeFactory;
import part2.factoryMethod.iShape;

public class CircleFactory extends ShapeFactory {

    private static int circleCounter = 0;
    @Override
    public iShape create() {
        iShape shape = new Circle();
        shape.setName("Круг_" + (++circleCounter));
        return shape;
    }
}
