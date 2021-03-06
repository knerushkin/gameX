package user;

import game.Choosable;
import game.Game;
import game.event.GameElement;
import game.event.AbstractPrivilege;
import game.event.Privilege;
import user.handlers.Privileges;
import user.strategy.ChoiceStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by knerushkin on 20/03/2017.
 */
public class Player {

    private String name;

    private int bank;

    private int money;

    private Map<Game, Statistic> gameStatistics = new HashMap<>();

    private Privileges privileges = new Privileges();

    private ChoiceStrategy<Choosable> gameStrategy;



    // Priveleges move to interface
    public boolean hasPrivileges(GameElement element) {
        return false;
    }

    public Privileges getPriveleges() {
        return this.privileges;
    }

    public void setPrivilege(AbstractPrivilege privilege) {
        privileges.add(privilege);
    }

    public boolean usePrivilege(GameElement element) {
        AbstractPrivilege privilege = this.privileges.handle(element);
        if(privilege == null) return false;
        return true;
    }

    public void resetPrivilege() { this.privileges.reset(); }
    // Priveleges move to interface

    /*
     * Construtcor
     */
    public Player(String name, ChoiceStrategy<Choosable> gameStrategy) {
        this.name = name;
        this.gameStrategy = gameStrategy;
    }


    //TODO: Consider necessity money getter/setter
    public int setMoney(int money) {
        this.money += money;
        return money;
    }

    public int getMoney() {
        return this.money;
    }

    // TODO:REFACTORING
    public void play(Game game) {

        // Find game statistics
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
            if (choosable != null) reward += choosable.execute(this, game);
        }
        statistic.update(reward);
        game.exit();
    }

    public Statistic getGameStatistics(Game game) {
        if(gameStatistics.containsKey(game))
            return gameStatistics.get(game);
        else {
            System.out.println("Player not played this game");
            return null;
        }
    }

    public Choosable choose(List<? extends Choosable> elements) {
        return this.gameStrategy.choose(elements);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", gameStrategy=" + gameStrategy +
                '}';
    }
}
