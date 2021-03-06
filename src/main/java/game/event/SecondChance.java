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
public class SecondChance extends AbstractPrivilege implements Terminate {

    private boolean executed;

    public SecondChance() { }

    public SecondChance(SecondChance event) { super(); }

    @Override
    public int execute(Player player, Game game) {
        this.executed = true;
        int reward = 0;
        Choosable choosable;
        while(!game.isTerminated()) {
            choosable = game.play(player);
            if (choosable != null) reward += choosable.execute(player, game);
        }
        return reward;
    }

    @Override
    public boolean isExecuted() {
        return executed;
    }

    @Override
    public void reset() {
        this.executed = false;
    }

    @Override
    public void terminate(Player player, Game game) {
        this.execute(player, game);
    }

    @Override
    public List<? extends GameElement> quantity(int n) {
        return Stream.generate(() -> new SecondChance(this)).limit(n).collect(Collectors.toList());
    }

    @Override
    public AbstractPrivilege handle(GameElement element) {
        return null;
    }
}
