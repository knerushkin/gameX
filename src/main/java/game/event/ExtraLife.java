package game.event;

import game.Game;
import user.Player;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ekanner on 2017-03-23.
 */
public class ExtraLife extends AbstractPrivilege {

    private boolean executed;

    public ExtraLife() {
        super();
    }

    public ExtraLife(ExtraLife other) {
        super();
    }


    @Override
    public void reset() {
        this.executed = false;
    }

    @Override
    public int execute(Player player, Game game) {
        this.executed = true;
        player.setPrivilege(this);
        return 0;
    }

    @Override
    public boolean isExecuted() {
        return executed;
    }

    @Override
    public List<? extends GameElement> quantity(int n) {
        return Stream.generate(() -> new ExtraLife(this)).limit(n).collect(Collectors.toList());
    }

    @Override
    public AbstractPrivilege handle(GameElement element) {
        if( element instanceof Terminate)
            return this.remove();
        return this.next().handle(element);
    }
}
