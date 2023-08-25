package part2.factoryMethod.shapes;

import part2.factoryMethod.iShape;

public class Square implements iShape {

    private String name;
    @Override
    public void generate() {
        System.out.println("Создан новый квадрат " + this.name);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
