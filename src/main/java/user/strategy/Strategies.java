package user.strategy;

/**
 * Created by knerushkin on 23/03/2017.
 */
public  class Strategies {

    public static ChoiceStrategy getRandom() {
        return new RandomChoiceStrategy();
    }

    public static ChoiceStrategy getSequence() {
        return new SequenceChoiceStrategy();
    }

    public static ChoiceStrategy getLastFirst() {
        return new LastFirstChoiceStrategy();
    }
}
