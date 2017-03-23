import game.Game;
import game.event.*;
import user.strategy.LastFirstChoiceStrategy;
import user.Player;
import user.strategy.RandomChoiceStrategy;
import user.strategy.SequenceChoiceStrategy;
import user.strategy.Strategies;

import java.util.Arrays;

/**
 * Created by knerushkin on 20/03/2017.
 */
public class Simulation {

    final static int GAME_BUDGET = 10000000;

    public static void main(String[] args) {

        Game game = new Game.GameBuilder(GAME_BUDGET)
                .addContent(Contents.getMoney(100).quantity(3))
                .addContent(Contents.getMoney(20).quantity(5))
                .addContent(Contents.getMoney(5).quantity(9))
                .addContent(Contents.getEvent(EventType.GAME_OVER)
                                    .addAdditionalContent(Contents.getMoney(5))
                                    .addAdditionalContent(Contents.getMoney(10))
                                    .addAdditionalContent(Contents.getMoney(20))
                                    .addAdditionalContent(Contents.getEvent(EventType.SECOND_CHANCE))
                                    .quantity(3))
                //.addContent(Contents.getEvent(EventType.EXTRA_LIFE))
                .build();

        System.out.println(game.getElements());

        Player player1 = new Player(Strategies.getRandom());
        Player player2 = new Player(Strategies.getRandom());
        Player player3 = new Player(Strategies.getRandom());
        Player player4 = new Player(Strategies.getSequence());
        Player player5 = new Player(Strategies.getLastFirst());

        Player[] players = { player1, player2, player3, player4, player5 };

        while(!game.isBankEmpty())
            for(Player player: players)
                player.play(game);

        System.out.println();

        for(Player player: players)
            System.out.println(player.getMoney());

        System.out.println();
        System.out.println(Arrays.stream(players).mapToInt(Player::getMoney).sum());
    }
}
