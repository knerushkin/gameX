package user.strategy;

import java.util.List;

/**
 * Created by knerushkin on 20/03/2017.
 */
public abstract class ChoiceStrategy<T> {

    public abstract T choose(List<? extends T> list);

    @Override
    public String toString() {
        return "ChoiceStrategy{" + this.getClass().getSimpleName() + "}";
    }
}
