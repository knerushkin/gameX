package game.event;

import game.Game;
import user.Player;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by knerushkin on 22/03/2017.
 */
public class SecondChance extends Event {

    private boolean executed;

    public SecondChance() { }

    public SecondChance(SecondChance event) {
        super(event);
    }

    @Override
    public void execute(Player player, Game game) {
        this.executed = true;
        System.out.println("SECOND CHANCE");
        player.play(game);
    }

    public void terminate(Player player, Game game) {
        this.executed = true;
        player.play(game);
    }

    @Override
    public boolean isExecuted() {
        return false;
    }

    @Override
    public void reset() {
        this.executed = false;
    }

    @Override
    public List<? extends GameElement> quantity(int n) {
        return Stream.generate(() -> new SecondChance(this)).limit(n).collect(Collectors.toList());
    }
}
