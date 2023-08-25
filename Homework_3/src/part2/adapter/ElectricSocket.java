package part2.adapter;

public class ElectricSocket {
    public void supplyElectricity(int voltage, Plug plug) {
        if (fits(plug)) {
            plug.plugIn();
            System.out.println("Электричество поступает. Напряжение " + voltage + " вольт.");
        } else {
            System.out.println("Вилка не подходит.");
        }
    }

    private boolean fits (Plug plug) {
        return (plug instanceof AmericanPlug);
    }
}
