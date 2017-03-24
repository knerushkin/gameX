package game.event;

/**
 * Created by knerushkin on 21/03/2017.
 */
public enum EventType {
    EXTRA_LIFE,
    GAME_OVER,
    SECOND_CHANCE ;

    public GameElement getEvent() {
        switch (this) {
            case GAME_OVER:
                return new GameOver();
            case SECOND_CHANCE:
                return new SecondChance();
            case EXTRA_LIFE:
                return new ExtraLife();
            default:
                throw new AssertionError("Unknown operations " + this);
        }
    }

}