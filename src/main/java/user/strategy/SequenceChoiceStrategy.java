package user.strategy;

import java.util.List;

/**
 * Created by knerushkin on 22/03/2017.
 */
public class SequenceChoiceStrategy<T> implements ChoiceStrategy<T> {

    @Override
    public T choose(List<? extends T> elements) {
        if(elements.isEmpty()) return null;
        return elements.get(0);
    }

}
