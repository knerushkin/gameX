package game.event;

import game.Choosable;
import game.Game;
import user.Player;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by knerushkin on 22/03/2017.
 */
public class GameOver extends Event implements Terminate {

    private boolean executed;

    public GameOver() {
        super();
    }

    public GameOver(GameOver other) {
        super(other);
    }

    @Override
    public void reset() {
        if(additionalRewards != null) additionalRewards.stream().forEach(Executable::reset);
        this.executed = false;
    }

    @Override
    public int execute(Player player, Game game) {
        this.executed = true;
        int result = 0;
        if(player.usePrivilege(this));
        else {
            // TODO: Money reward not removed from additional rewards pool in case they were chosen
            if(!this.additionalRewards.isEmpty()) {
                Choosable choosable = player.choose(this.additionalRewards);
                result = choosable.execute(player, game);
                int a = 1;
            }
            this.terminate(player, game);
        }
        return result;
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
        game.terminate(player);
    }
}
