/*
Шаблон Singleton:
Реализуйте паттерн Singleton для класса Logger,
который будет использоваться для логирования информации в приложении.
Гарантируйте, что только один экземпляр класса Logger будет создан.
 */

package part1.singleton;

public class Main {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();

        logger1.log("Сообщение №1");
        logger1.log("Сообщение №2");
        logger1.printLog();

        Logger logger2 = Logger.getInstance();
        logger2.log("Сообщение №3");
        logger2.log("Сообщение №4");
        logger2.printLog();

        if (logger1 == logger2) {
            System.out.println("Это один и тот же экземпляр класса Logger");
        } else {
            System.out.println("Это разные экземпляры класса Logger");
        }


    }
}
