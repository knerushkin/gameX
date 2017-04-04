package user.strategy;

/**
 * Created by knerushkin on 23/03/2017.
 */
public  class Strategies {

    public static ChoiceStrategy getRandomChoice() {
        return new RandomChoiceStrategy();
    }

    public static ChoiceStrategy getFirstChoice() {
        return new FirstChoiceStrategy();
    }

    public static ChoiceStrategy getLastChoice() {
        return new LastChoiceStrategy();
    }
}
