package part1.observer;

public class Observer {
    private String name;

    public Observer(String name) {
        this.name = name;
    }

    public void update(String news) {
        System.out.printf("Наблюдатель %s получил уведомление: %s.\n", this.name, news);
    }
}
