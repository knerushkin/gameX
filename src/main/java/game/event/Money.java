package game.event;

import game.Game;
import user.Player;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by knerushkin on 20/03/2017.
 */
public class Money extends GameElement {

    private int money;

    private boolean executed;

    public Money(int money) { this.money = money; }

    public Money(Money other) { this.money = other.money; }

    @Override
    public int execute(Player player, Game game) {
        this.executed = true;
        return player.setMoney(game.getMoney(money));
        //player.play(game);
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
        player.setMoney(game.getMoney(money));
    }

    @Override
    public List<Money> quantity(int n) {
        return Stream.generate(() -> new Money(this)).limit(n).collect(Collectors.toList());
    }

}
