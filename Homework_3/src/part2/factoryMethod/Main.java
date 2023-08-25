/*
Фабричный метод:
Реализуйте паттерн Фабричный метод для создания геометрических фигур.
Создайте класс ShapeFactory, имеющий метод create_shape(), который возвращает объекты различных геометрических фигур.
 */

package part2.factoryMethod;

import part2.factoryMethod.shapes.CircleFactory;
import part2.factoryMethod.shapes.SquareFactory;
import part2.factoryMethod.shapes.TriangleFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<ShapeFactory> factoryList = new ArrayList<>();
        factoryList.add(new CircleFactory());
        factoryList.add(new SquareFactory());
        factoryList.add(new TriangleFactory());
        factoryList.add(new CircleFactory());
        factoryList.add(new CircleFactory());
        factoryList.add(new TriangleFactory());
        factoryList.add(new SquareFactory());
        factoryList.add(new CircleFactory());
        factoryList.add(new TriangleFactory());
        factoryList.add(new SquareFactory());
        factoryList.add(new TriangleFactory());
        factoryList.add(new CircleFactory());
        factoryList.add(new CircleFactory());

        for (int i = 0; i < factoryList.size(); i++) {
            factoryList.get(i).createShape();
        }
    }
}
