package part2.factoryMethod.shapes;

import part2.factoryMethod.iShape;

public class Circle implements iShape {

    private String name;
    @Override
    public void generate() {
        System.out.println("Создан новый круг " + this.name);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
