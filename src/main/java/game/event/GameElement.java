package game.event;

import game.Choosable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by knerushkin on 20/03/2017.
 */
public abstract class GameElement implements Executable, Choosable {

    protected List<GameElement> additionalRewards;

    public abstract List<? extends GameElement> quantity(int n);

    public GameElement() { }

    public GameElement(GameElement other) {
        this.additionalRewards = other.additionalRewards;
    }

    //public String toString() { return this.getClass().getSimpleName(); }

    public GameElement addAdditionalContent(GameElement element) {
        if(additionalRewards == null) additionalRewards = new ArrayList<GameElement>();
        additionalRewards.add(element);
        return this;
    }

    public GameElement addAdditionalContent(List<? extends GameElement> elements) {
        if(additionalRewards == null) additionalRewards = new ArrayList<GameElement>();
        additionalRewards.addAll(elements);
        return this;
    }

    public String toString() {
        return super.toString() + " " + this.isExecuted();
    }
}
