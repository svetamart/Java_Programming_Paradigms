package part1.observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationSystem {
    private List<Observer> observers;
    private String message;

    public NotificationSystem() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public void notifyObservers() {
        for (Observer o : observers)
            o.update(message);
    }
}
