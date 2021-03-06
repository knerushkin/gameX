package game;

import game.event.AbstractPrivilege;
import game.event.Executable;
import game.event.GameElement;
import user.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by knerushkin on 20/03/2017.
 */

/*
 * Make game.Game abstract, MainGame operate on Boxes?
 *
 * game.Game singleton, composition with RewardPool and AdditionalRewardPool
 *
 * GameOverSign
 * ExtraLifeSign deny GameOverSign
 * SecondChanceSign return game in the previous state
 *
 * Injection of user.Player into game.Game, game.Game executes choose strategy on reward.Reward Collection
 */

public class Game {

    List<Box> boxes;
    List<GameElement> elements;

    private boolean terminated;

    private int bank;

    private Game(GameBuilder builder) {
        this.elements = builder.elements;
        this.boxes = builder.elements.stream().map(Box::new).collect(Collectors.toList());
        this.bank = builder.bank;
    }

    public Choosable play(Player player) {

        List<Choosable> activeBoxes = this.boxes.stream()
                .filter((b) -> !b.isExecuted())
                .collect(Collectors.toList());
        if(activeBoxes.isEmpty()) {
            this.terminate(player);
            return null;
        }
        else
            return player.choose(activeBoxes);
    }

    public int getBank() { return this.bank; }

    public boolean isBankEmpty() {
        if(this.bank < 0)
            return true;
        return false;
    }

    public int getMoney(int money) {
        this.bank -= money;
        return money;
    }

    // TODO: access modifier. visible only in terminator event. exclude from user interface
    public void terminate(Player player) {
        List<Box> privi = boxes.stream().filter(box -> { return box.element instanceof AbstractPrivilege;}).collect(Collectors.toList());
        player.resetPrivilege();
        this.terminated = true;
        boxes.stream().forEach(Executable::reset);
    }

    public boolean isTerminated() { return this.terminated; }

    public void exit() {
        Collections.shuffle(this.boxes);
        this.terminated = false;
    }

    public List<Box> getBoxes() {
        return boxes;
    }


    public static class GameBuilder {

        private int bank;

        List<Box> boxes = new ArrayList<Box>();

        List<GameElement> elements = new ArrayList<GameElement>();

        public GameBuilder(int money) { this.bank = money; }

        public GameBuilder addContent(GameElement element) {
            this.elements.add(element);
            return this;
        }

        public GameBuilder addContent(List<? extends GameElement> elements) {
            this.elements.addAll(elements);
            return this;
        }

        public Game build() {
            Collections.shuffle(this.elements);
            return new Game(this);
        }

    }
}
