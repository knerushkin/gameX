package game.event;

import game.Choosable;

import java.util.List;

/**
 * Created by knerushkin on 20/03/2017.
 */
public abstract class GameElement implements Executable, Terminate, Choosable {

    public abstract List<? extends GameElement> quantity(int n);

    public String toString() { return this.getClass().getSimpleName(); }
}
