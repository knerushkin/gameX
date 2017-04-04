import game.Game;
import game.event.*;
import user.Player;
import user.strategy.Strategies;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by knerushkin on 20/03/2017.
 */
public class Simulation {

    private final static int GAME_BUDGET = 10000000;

    public static void main(String[] args) {

        Game game = new Game.GameBuilder(GAME_BUDGET)
                .addContent(Contents.getMoney(100))
                .addContent(Contents.getMoney(20).quantity(3))
                .addContent(Contents.getMoney(5).quantity(5))
                .addContent(Contents.getEvent(EventType.GAME_OVER)
                                    .addAdditionalContent(Contents.getMoney(5))
                                    .addAdditionalContent(Contents.getMoney(10))
                                    .addAdditionalContent(Contents.getMoney(20))
                                    .addAdditionalContent(Contents.getEvent(EventType.SECOND_CHANCE).quantity(2))
                                    .quantity(1))
                .addContent(Contents.getEvent(EventType.EXTRA_LIFE).quantity(1))
                .build();

        List<Player> players = new ArrayList<>();
        players.add(new Player("Bill", Strategies.getRandomChoice()));
        players.add(new Player("Ralph", Strategies.getRandomChoice()));
        players.add(new Player("Andrew", Strategies.getRandomChoice()));
        players.add(new Player("Nick", Strategies.getFirstChoice()));
        players.add(new Player("David", Strategies.getLastChoice()));

        while(!game.isBankEmpty())
            for (Player player : players)
                player.play(game);

        for(Player player: players) {
            System.out.println();
            System.out.println(player.toString() + " " + player.getGameStatistics(game));
        }
    }
}
