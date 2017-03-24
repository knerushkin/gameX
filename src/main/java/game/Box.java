package game;

import game.event.GameElement;
import user.Player;

/**
 * Created by knerushkin on 20/03/2017.
 */
public class Box implements Choosable {

    GameElement element;

    public Box(GameElement element) { this.element = element; }

    @Override
    public void reset() {
        this.element.reset();
    }

    public int execute(Player player, Game game) {
        return this.element.execute(player, game);
    }

    @Override
    public boolean isExecuted() {
        return this.element.isExecuted();
    }

    @Override
    public String toString() {
        return this.element.toString();
    }

}