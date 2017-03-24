package game.event;

import game.Game;
import user.Player;

/**
 * Created by knerushkin on 22/03/2017.
 */
public interface Executable {

    void reset();

    int execute(Player player, Game game);

    boolean isExecuted();

}
