import game.Game;
import game.event.*;
import user.strategy.LastFirstChoiceStrategy;
import user.Player;
import user.strategy.RandomChoiceStrategy;
import user.strategy.SequenceChoiceStrategy;
import user.strategy.Strategies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by knerushkin on 20/03/2017.
 */
public class Simulation {

    private final static int GAME_BUDGET = 10000000;

    public static void main(String[] args) {

        Game game1 = new Game.GameBuilder(GAME_BUDGET)
                .addContent(Contents.getMoney(100))
                .addContent(Contents.getMoney(20).quantity(3))
                .addContent(Contents.getMoney(5).quantity(5))
                .addContent(Contents.getEvent(EventType.GAME_OVER)
                                    .addAdditionalContent(Contents.getMoney(5))
                                    .addAdditionalContent(Contents.getMoney(10))
                                    .addAdditionalContent(Contents.getMoney(20))
                                    .addAdditionalContent(Contents.getEvent(EventType.SECOND_CHANCE))
//                                    .quantity(3))
                )
                .addContent(Contents.getEvent(EventType.EXTRA_LIFE).quantity(5))
                .build();
        System.out.println(game1.getBoxes());

        Game game2 = new Game.GameBuilder(GAME_BUDGET)
                .addContent(Contents.getMoney(300).quantity(3))
                .addContent(Contents.getMoney(20).quantity(4))
                .addContent(Contents.getMoney(5).quantity(5))
                .addContent(Contents.getEvent(EventType.GAME_OVER)
                        .addAdditionalContent(Contents.getMoney(5))
                        .addAdditionalContent(Contents.getMoney(10))
                        .addAdditionalContent(Contents.getMoney(20))
                        .addAdditionalContent(Contents.getEvent(EventType.SECOND_CHANCE))
                        .quantity(2))
                //.addContent(Contents.getEvent(EventType.EXTRA_LIFE))
                .build();

        List<Player> players = new ArrayList<>();
//        players.add(new Player(Strategies.getRandom()));
        players.add(new Player(Strategies.getRandom()));
//        players.add(new Player(Strategies.getRandom()));
//        players.add(new Player(Strategies.getSequence()));
//        players.add(new Player(Strategies.getLastFirst()));

        while(!game1.isBankEmpty()) {
//            System.out.println(game1.getBoxes());
//            System.out.println();
            System.out.println(game1.getBoxes());
            for (Player player : players)
                player.play(game1);
        }

        // TODO:REFACTORING: game start point move to Game.play(player)
//        while(!game2.isBankEmpty()) {
////            System.out.println(game2.getBoxes());
////            System.out.println();
//            for (Player player : players)
//                player.play(game2);
//        }

        System.out.println();

        for(Player player: players) {
            System.out.println();
            System.out.println(player.getGameStatistics(game1));
//            System.out.println(player.getGameStatistics(game2));
        }

        System.out.println();
        System.out.println(players.stream().mapToInt(Player::getMoney).sum());
    }
}
