package user.strategy;

import java.util.List;

/**
 * Created by knerushkin on 20/03/2017.
 */
public interface ChoiceStrategy<T> {
    T choose(List<T> list);
}
