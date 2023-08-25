package part2.factoryMethod;

public abstract class ShapeFactory {
    public void createShape()
    {
        iShape shape = create();
        shape.generate();
    }
    public abstract iShape create();
}
