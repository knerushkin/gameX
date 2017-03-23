package game.event;

import java.util.List;

/**
 * Created by knerushkin on 20/03/2017.
 */
public abstract class GameElement implements Executable, Terminate{

    public abstract List<? extends GameElement> quantity(int n);

}
