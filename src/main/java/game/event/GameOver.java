package game.event;

import game.Game;
import user.Player;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by knerushkin on 22/03/2017.
 */
public class GameOver extends Event {

    private boolean executed;

    public GameOver() {
        super();
    }

    public GameOver(GameOver other) {
        super(other);
    }

    @Override
    public void reset() {
        this.executed = false;
    }

    @Override
    public void execute(Player player, Game game) {
        this.executed = true;
        if(!this.additionalRewards.isEmpty()) {
            GameElement element = player.choose(this.additionalRewards);
            element.terminate(player, game);
        }
        game.terminate(player);
    }

    @Override
    public boolean isExecuted() {
        return executed;
    }

    @Override
    public List<? extends GameElement> quantity(int n) {
        return Stream.generate(() -> new GameOver(this)).limit(n).collect(Collectors.toList());
    }

    @Override
    public void terminate(Player player, Game game) {

    }
}
