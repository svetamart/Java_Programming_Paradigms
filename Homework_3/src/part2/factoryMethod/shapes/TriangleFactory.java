package part2.factoryMethod.shapes;

import part2.factoryMethod.ShapeFactory;
import part2.factoryMethod.iShape;

public class TriangleFactory extends ShapeFactory {
    private static int triangleCounter = 0;
    @Override
    public iShape create() {
        iShape shape = new Triangle();
        shape.setName("Треугольник_" + (++triangleCounter));
        return shape;
    }
}
