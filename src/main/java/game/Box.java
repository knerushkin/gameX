package game;

import game.event.GameElement;

/**
 * Created by knerushkin on 20/03/2017.
 */

public class Box {

    GameElement element;

    public Box(GameElement element) { this.element = element; }

//    public boolean isEmpty() { return this.reward.isExecuted(); }

    public GameElement getElement() { return this.element; }

}
