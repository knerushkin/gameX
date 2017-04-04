package user.handlers;

import game.event.AbstractPrivilege;
import game.event.GameElement;
import game.event.Privilege;

/**
 * Created by ekanner on 2017-03-23.
 */
public class Privileges {

    private AbstractPrivilege root = new Privilege();

    public void print() {
        if(root == null) return;

        AbstractPrivilege nextPrivilege = root;
        while (nextPrivilege.hasNext()) {
            nextPrivilege = nextPrivilege.getNext();
            System.out.println(nextPrivilege);
        }
    }

    public void reset() {
        if(root != null)
            while(root.hasNext()) root.next().remove();
    }

    public void add(AbstractPrivilege privilege) {
        root.setNext(privilege);
    }

    public AbstractPrivilege handle(GameElement element) {
        return this.root == null ? null : this.root.handle(element);
    }

}
