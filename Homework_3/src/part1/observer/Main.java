/*
Шаблон Наблюдатель:
Реализуйте паттерн Наблюдатель для системы уведомлений.
Создайте класс NotificationSystem (наблюдаемый объект),
который будет иметь методы для добавления наблюдателей и уведомления о событиях.
Создайте несколько наблюдателей, реагирующих на уведомления.
 */

package part1.observer;

public class Main {

    public static void main(String[] args) {

        NotificationSystem notificator = new NotificationSystem();
        Observer observer1 = new Observer("Наблюдатель 1");
        Observer observer2 = new Observer("Наблюдатель 2");
        Observer observer3 = new Observer("Наблюдатель 3");

        notificator.addObserver(observer1);
        notificator.addObserver(observer2);
        notificator.addObserver(observer3);

        notificator.setMessage("Очень Важное Сообщение");
        notificator.notifyObservers();

    }
}
