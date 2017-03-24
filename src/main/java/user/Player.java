package user;

import game.Box;
import game.Choosable;
import game.Game;
import game.event.GameElement;
import game.event.Priveledge;
import user.strategy.ChoiceStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by knerushkin on 20/03/2017.
 */
public class Player {

    private int bank;

    private int money;

    private Map<Game, Statistic> gameStatistics = new HashMap<>();

    private List<Priveledge> priveledges = new ArrayList<>();

    private ChoiceStrategy<Choosable> gameStrategy;

    public boolean hasPrivileges(GameElement element) {
        System.out.println("has privileges");
        System.out.println(priveledges);
        System.out.println(priveledges.size());
        return false;
    }

    public void setPrivilege(Priveledge priveledge) {
        priveledges.add(priveledge);
    }

    public void usePrivilege(GameElement element) {  }

    public void resetPrivilege() { this.priveledges.clear(); }

    public Player(ChoiceStrategy<Choosable> gameStrategy) {
        this.gameStrategy = gameStrategy;
    }

    public int setMoney(int money) { this.money += money; return money; }

    public int getMoney() { return this.money; }

    public void play(Game game) {

        Statistic statistic;
        if(gameStatistics.containsKey(game))
            statistic = gameStatistics.get(game);
        else {
            statistic = new Statistic();
            gameStatistics.put(game, statistic);
        }

        int reward = 0;
        Choosable choosable;
        while(!game.isTerminated()) {
            choosable = game.play(this);
            System.out.println(choosable);
            if (choosable != null) reward += choosable.execute(this, game);
        }
        statistic.update(reward);
        //System.out.println(reward);
        game.exit();
    }

    public Statistic getGameStatistics(Game game) {
        if(gameStatistics.containsKey(game))
            return gameStatistics.get(game);
        else return null;
    }

    public  Choosable choose(List<? extends Choosable> elements) {
        return gameStrategy.choose(elements);
    }

}
