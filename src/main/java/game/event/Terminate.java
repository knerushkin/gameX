package game.event;

import game.Game;
import user.Player;

/**
 * Created by knerushkin on 22/03/2017.
 */
public interface Terminate {
    void terminate(Player player, Game game);
}
