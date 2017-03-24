package user.handlers;

import game.event.AbstractPrivilege;
import game.event.GameElement;
import game.event.Privilege;

/**
 * Created by ekanner on 2017-03-23.
 */
public class Privileges {

    private Privilege root = new Privilege();

    public void reset() {
        while(root.hasNext()) root.next().remove();
    }

    public void add(AbstractPrivilege privilege) {
        root.setNext(privilege);
    }

    public AbstractPrivilege handle(GameElement element) {
        return this.root.handle(element);
    }

}
