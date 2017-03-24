package game.event;

/**
 * Created by knerushkin on 20/03/2017.
 */
public class Contents {

    static public Money getMoney(int money) {
        return new Money(money);
    }

    static public GameElement getEvent(EventType eventType) {
        return eventType.getEvent();
    }
}
