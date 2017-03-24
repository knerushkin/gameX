package game.event;

import game.Game;
import user.Player;

import java.util.Arrays;
import java.util.List;

/**
 * Created by knerushkin on 24/03/2017.
 */
public class Privilege extends AbstractPrivilege {
    @Override
    public void reset() { }

    @Override
    public int execute(Player player, Game game) { return 0; }

    @Override
    public boolean isExecuted() { return false; }

    @Override
    public List<? extends GameElement> quantity(int n) {
        return Arrays.asList(this);
    }

    @Override
    public AbstractPrivilege handle(GameElement element) {
        return next == null? null: next.handle(element);
    }
}
