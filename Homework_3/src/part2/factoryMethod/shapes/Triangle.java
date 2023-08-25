package part2.factoryMethod.shapes;

import part2.factoryMethod.iShape;

public class Triangle implements iShape {
    private String name;
    @Override
    public void generate() {
        System.out.println("Создан новый треугольник " + this.name);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
