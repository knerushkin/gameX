package game.event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by knerushkin on 21/03/2017.
 */
public abstract class Event extends GameElement {


    public Event() { }

    public Event(Event other) {  }

    @Override
    public String toString() { return this.getClass().getSimpleName(); }


}
