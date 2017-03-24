package game.event;

import game.Game;
import user.Player;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by knerushkin on 22/03/2017.
 */
public class SecondChance extends Event implements Priveledge {

    private boolean executed;

    public SecondChance() { }

    public SecondChance(SecondChance event) {
        super(event);
    }

    @Override
    public int execute(Player player, Game game) {
        this.executed = true;
        player.setPrivilege(this);
        System.out.println("SECOND CHANCE");
        //player.play(game);
        return 0;
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
    public void terminate(Player player, Game game) {
        this.execute(player, game);
    }

    @Override
    public List<? extends GameElement> quantity(int n) {
        return Stream.generate(() -> new SecondChance(this)).limit(n).collect(Collectors.toList());
    }
}
