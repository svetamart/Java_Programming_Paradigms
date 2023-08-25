/*
Адаптер:
Создайте класс ElectricSocket, который имеет метод supply_electricity(voltage).
Реализуйте класс USPlugAdapter, который адаптирует розетку стандарта США к европейскому стандарту.
Создайте объекты и продемонстрируйте передачу электроэнергии через адаптер.
 */

package part2.adapter;

public class Main {
    public static void main(String[] args) {

        ElectricSocket socket = new ElectricSocket();

        AmericanPlug americanPlug = new AmericanPlug();
        EuropeanPlug europeanPlug = new EuropeanPlug();

        System.out.println("Вставляем в розетку американскую вилку.");
        socket.supplyElectricity(220, americanPlug);

        System.out.println();

        System.out.println("Вставляем в розетку европейскую вилку.");
        socket.supplyElectricity(220, europeanPlug);

        System.out.println();

        System.out.println("Используем адаптер для розетки.");
        USPlugAdapter adapter = new USPlugAdapter(europeanPlug);
        socket.supplyElectricity(220, adapter);



    }
}
