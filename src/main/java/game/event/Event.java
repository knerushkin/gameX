package game.event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by knerushkin on 21/03/2017.
 */
public abstract class Event extends GameElement implements Executable{

    protected List<GameElement> additionalRewards;

    public Event() { }

    public Event(Event other) { this.additionalRewards = other.additionalRewards; }

    @Override
    public String toString() { return this.getClass().getSimpleName(); }

    public Event addAdditionalContent(GameElement element) {
        if(additionalRewards == null) additionalRewards = new ArrayList<GameElement>();
        additionalRewards.add(element);
        Collections.shuffle(additionalRewards);
        return this;
    }

    public Event addAdditionalContent(List<? extends GameElement> elements) {
        if(additionalRewards == null) additionalRewards = new ArrayList<GameElement>();
        additionalRewards.addAll(elements);
        Collections.shuffle(additionalRewards);
        return this;
    }
}
