package user.strategy;

import java.util.List;
import java.util.Random;

/**
 * Created by knerushkin on 20/03/2017.
 */
public class RandomChoiceStrategy<T> implements ChoiceStrategy<T> {

    @Override
    public T choose(List<? extends T> elements) {
        if(elements.isEmpty()) return null;
        if(elements.size() == 1) return elements.get(0);
        return elements.get(new Random().nextInt(elements.size()));
    }

}
