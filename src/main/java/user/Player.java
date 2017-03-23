package user;

import game.Game;
import game.event.GameElement;
import user.strategy.ChoiceStrategy;

import java.util.List;

/**
 * Created by knerushkin on 20/03/2017.
 */
public class Player {

    int roundNum;

    int money;

    ChoiceStrategy<GameElement> gameStrategy;

    public Player(ChoiceStrategy<GameElement> gameStrategy) {
        this.gameStrategy = gameStrategy;
    }

    public int setMoney(int money) { this.money += money; return money; }

    public int getMoney() { return this.money; }

    public void play(Game game) {
        GameElement element = game.play(this);
        if(element != null) element.execute(this, game);
    }

    public GameElement choose(List<GameElement> elements) {
        return gameStrategy.choose(elements);
    }

}
