package game.event;

/**
 * Created by knerushkin on 21/03/2017.
 */
public enum EventType {
    //EXTRA_LIFE { Event getEvent( new)},
    GAME_OVER,
    SECOND_CHANCE ;

    public Event getEvent() {
        switch (this) {
            case GAME_OVER:
                return new GameOver();
            case SECOND_CHANCE:
                return new SecondChance();
            default:
                throw new AssertionError("Unknown operations " + this);
        }
    }

}